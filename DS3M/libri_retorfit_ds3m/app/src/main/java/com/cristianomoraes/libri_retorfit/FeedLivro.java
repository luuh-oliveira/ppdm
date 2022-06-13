package com.cristianomoraes.libri_retorfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cristianomoraes.libri_retorfit.model.Item;
import com.cristianomoraes.libri_retorfit.model.Livro;
import com.cristianomoraes.libri_retorfit.remote.APIUtil;
import com.cristianomoraes.libri_retorfit.remote.RouterInterface;

import java.util.ArrayList;
import java.util.List;

//req
import retrofit2.Call;
//e
import retrofit2.Callback;
import retrofit2.Response;

public class FeedLivro extends AppCompatActivity {

    /** ATRIBUTOS **/

    RouterInterface routerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_livro);

        /** CONECTA O APLICATIVO COM A API **/
        routerInterface = APIUtil.getUsuarioInterface();

        /** CHAMADA PARA ROTA DE LISTAGEM **/
        Call<List<Livro>> call = routerInterface.getLivros();

        //resposta da api - callback
        call.enqueue(new Callback<List<Livro>>() {
            @Override
            public void onResponse(Call<List<Livro>> call, Response<List<Livro>> response) {

                if (response.isSuccessful()){

                    List<Item> itens = new ArrayList<>();

                    /** RECEBE OS DADOS DA API **/
                    List<Livro> list = new ArrayList<Livro>();
                    list = response.body();

                    for (int i = 0; i < list.size(); i++){
                        itens.add(new Item(0, list.get(i)));
                    }

                    RecyclerView recyclerView = findViewById(R.id.recyclerView);
                    recyclerView.setAdapter(new LivroAdapter(itens));


                }

            }

            //usado para caso a api n consiga retornar a response
            @Override
            public void onFailure(Call<List<Livro>> call, Throwable t) {

            }
        });

    } // fim do OnCreate

    /** Adapter - Recycler view **/

    private class LivroAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        List<Item> itens;

        //construtor da adapter
        public LivroAdapter(List<Item> itens){
            this.itens = itens;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new LivroViewHolder(
                    LayoutInflater.from(
                            parent.getContext()
                    ).inflate(
                            R.layout.item_container_livro,
                            parent,
                            false
                    )
            );
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            /** DADOS DE LIVRO **/
            if (getItemViewType(position) == 0){

                //cast - converter object em Livro
                Livro livro = (Livro) itens.get(position).getObject();
                ((LivroAdapter.LivroViewHolder) holder).setLivroData(livro);

            }

            ///** DADOS DE HQ **/
            //if (getItemViewType(position) == 1){}

            ///** DADOS DE MANGÁ**/
            //if (getItemViewType(position) == 2){}



        }

        @Override
        public int getItemCount() {
            return itens.size();
        }

        public int getItemViewType(int position){
            return itens.get(position).getType();
        }

        /** CLASSE DE VIEWHOLDER DA RECYCLERVIEW
         * (monta a estrutura - pega o xml e traz para a LivroAdapter e injeta dados) **/
        class LivroViewHolder extends RecyclerView.ViewHolder{

            /** ATRIBUTOS - LIVRO VIEWHOLDER **/
            private TextView txtTitulo, txtDescricao;
            private int cod_livro;


            //construtor
            public LivroViewHolder(@NonNull View itemView) {
                super(itemView);


                txtTitulo = itemView.findViewById(R.id.txtTitulo);
                txtDescricao = itemView.findViewById(R.id.txtDescricao);

                /** AÇÃO DE CLIQUE - EDITAR E EXCLUIR LIVRO **/
                itemView.setOnClickListener(view -> {

                    /**
                     * setMessage -> título da caixa de alerta
                     * setPositiveButton -> definine uma opção de ação
                     *      Parametros:
                     *          1- Titulo
                     *          2- Ação a ser executada
                     * setNegativeButton -> define uma opção de ação
                     * **/

                    //alertDialog abrirá no FeedLivro
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(FeedLivro.this)
                            .setMessage("Escolha a ação que deseja executar!")
                            .setPositiveButton("ALTERAR", (dialog1, witch)->{

                                Intent intent = new Intent(FeedLivro.this, AlterarLivro.class);
                                intent.putExtra("cod_livro", cod_livro);
                                startActivity(intent);

                            })
                            .setNegativeButton("EXCLUIR", (dialog1, witch)->{

                                //conexão
                                routerInterface = APIUtil.getUsuarioInterface();

                                Call<Livro> call = routerInterface.deleteLivro(cod_livro);

                                call.enqueue(new Callback<Livro>() {
                                    @Override
                                    public void onResponse(Call<Livro> call, Response<Livro> response) {

                                        Toast.makeText(FeedLivro.this, "LIVRO EXCLUÍDO COM SUCESSO", Toast.LENGTH_SHORT).show();

                                        startActivity(new Intent(FeedLivro.this, FeedLivro.class));

                                    }

                                    @Override
                                    public void onFailure(Call<Livro> call, Throwable t) {

                                    }
                                });

                            });

                    alertDialog.show();

                });



            } // fim do construtor da classe livro viewholder

            /** MÉTODO QUE CARREGA OS VALORES NOS ELEMENTOS DE TEXTVIEW **/
            public void setLivroData(Livro livro){

                txtTitulo.setText(livro.getTitulo());
                txtDescricao.setText(livro.getDescricao());
                cod_livro = livro.getCod_livro();

            }



        } // fim da classe livro view holder


    }


}