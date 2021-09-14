package com.example.calculadoracomplicada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    Button botao_soma;
    Button botao_mult;
    TextView resultado;
    EditText inserir;
    int [] pilha1 = new int [30];
    int [] pilha2 = new int [30];
    //int [] soma = new int[30];
    //int [] multiplicacao = new int[30];
    int [] meio = new int [30];
    int [] parcial = new int [30];
    String convercao, soma, multiplicacao;
    int i, j, k, l;
    int y, f;
    int qualmaior, vaiquanto, segura;
    Boolean primeiro = true, vaium = false;

    /*
    * pilha1 = guarda o primeiro número digitado
    * pilha2 = guarda o segundo numero digitado
    * soma = gauda o resultado final do botao de soma
    * multiplicacao = guarda o resultado final da multiplicacao
    * meio = guarda o resultado tanto de soma quanto de multiplicacao, mas com os algarismos ao contrario
    * parcial = guarda as somas graudias da multiplicacoes
    * convercao = converte o edit text para os vetores pilha1 e pilha2 , ao contrário
    * i = geralmente usado mara manter o meio
    * j = geralmente usado para regular o fim de números nas piilhas 1 e 2
    * k = geralmente usado para manejar pilha 1 e 2
    * l = guarda o tamanho de pilha2
    * y = para contar as casas que pulam na multiplicação
    * f = Para passar os algarismos na multiplicação
    * qualmaior = guarda o tamanho da pilha1
    * vaiquanto = guarda a soma de vai um (ex: 3*7 = 21 } vaiquanto = 2)
    * segura = serve como auxiliar em uma mudança no vetor (geralmente no meio)
    * primeiro = marca se o número digitado pelko usuário é o primeiro ou o segundo
    * vai um = confere a necessidade de um "vaium" (ex: 3*2 = 6 } vaium = false / 5*9 = 45 } vaium = true
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao_soma = findViewById(R.id.botao_soma);
        botao_mult = findViewById(R.id.botao_mult);
        resultado = findViewById(R.id.resultado);
        inserir = findViewById(R.id.inserir);

        for (i = 0; i < 30; i++) {
            pilha1[i] = -1;
            pilha2[i] = -1;
            parcial[i] = 0;
        }
    }


    public void irsoma(View f) {

        convercao = String.valueOf(inserir.getText());
        k = 29;
        l = convercao.length();
        if (primeiro) {
            for (j = 0; j < l; j++) {
                pilha1[k] = convercao.charAt(j);
                k--;
            }
            qualmaior = l;
            primeiro = false;
        } else {
            for (j = 29; j < l; j++) {
                pilha2[j] = convercao.charAt(j);
                k--;
            }
            mostrars();
            primeiro = true;
        }
    }

    public String somar(){
        //soma//////////////////////////////////////////////////////////////////////
        k = 29;
        i = 0;
        if (qualmaior >= l) {
            j = pilha1[k];
        } else {
            j = pilha2[k];
        }
        while (j != -1) {
            if (pilha1[k] != -1 && pilha2[k] != -1) {
                if (pilha1[k] + pilha2[k] < 10) {
                    meio[i] = pilha1[k] + pilha2[k];
                    if (vaium) {
                        meio[i] = meio[i] + 1;
                        if (meio[i] == 10) {
                            meio[i] = 0;
                            vaium = true;
                        } else {
                            vaium = false;
                        }
                    }
                } else {
                    meio[i] = ((pilha1[k] + pilha2[k]) % 10);
                    if (vaium) {
                        meio[i] = meio[i] + 1;
                    }
                    vaium = true;
                }
            } else {
                if (qualmaior >= l) {
                    meio[i] = pilha1[k];
                } else {
                    meio[i] = pilha2[k];
                }
                if (vaium) {
                    meio[i] = meio[i] + 1;
                    if (meio[i] == 10) {
                        meio[i] = 0;
                        vaium = true;
                    } else {
                        vaium = false;
                    }
                }
            }
            k--;
            i++;
            if (qualmaior >= l) {
                j = pilha1[k];
            } else {
                j = pilha2[k];
            }
        }

        //inverte meio para soma (que vai ser mostrada na view)
        k = meio.length - 1;
        for (i = 0; i < meio.length; i++) {
            soma = String.valueOf(meio[k]);
            k--;
        }
        return soma;
    }

    public void mostrars() {
        somar();
        resultado.setText(somar());
    }


    public void irmult(View f) {

        convercao = String.valueOf(inserir.getText());
        k = 29;
        l = convercao.length();
        if (primeiro) {
            for (j = 0; j < l; j++) {
                pilha1[k] = convercao.charAt(j);
                k--;
            }
            qualmaior = l;
            primeiro = false;
        } else {
            for (j = 29; j < l; j++) {
                pilha2[j] = convercao.charAt(j);
                k--;
            }
            mostrarm();
        }
    }

    public void mostrarm() {
        somar();
        resultado.setText(multiplicar());
    }

    public String multiplicar(){
        //multiplicação///////////////////////////////////////////////////////////////////////
        k = 29;
        i = 0;
        if (qualmaior >= l) {
            j = (pilha1[k]);
        } else {
            j = (pilha2[k]);
        }
        y = 0;
        while (y <= qualmaior) {
            k = 29;
            i = 0;
            f = 29;
            while (j != -1) {
                if (pilha1[k] != -1 && pilha2[f] != -1) {
                    if (pilha1[k] * pilha2[f] < 10) {
                        meio[i] = pilha1[k] * pilha2[f];
                    } else {
                        meio[i] = ((pilha1[k] * pilha2[f]) % 10);
                        vaiquanto = ((pilha1[k] * pilha2[f]) / 10);
                    }
                } else {
                    if (qualmaior >= l) {
                        meio[i] = pilha1[k];
                    } else {
                        meio[i] = pilha2[f];
                    }
                }
                if (vaium) {
                    switch (vaiquanto) {
                        case 1:
                            meio[i] = meio[i] + 1;
                            if (meio[i] >= 10) {
                                segura = (meio[i]);
                                meio[i] = (meio[i] % 10);
                                vaium = true;
                                vaiquanto = (segura / 10);
                            } else {
                                vaium = false;
                            }
                            break;
                        case 2:
                            meio[i] = meio[i] + 2;
                            if (meio[i] >= 10) {
                                segura = meio[i];
                                meio[i] = (meio[i] % 10);
                                vaium = true;
                                vaiquanto = (segura / 10);
                            } else {
                                vaium = false;
                            }
                            break;
                        case 3:
                            meio[i] = meio[i] + 3;
                            if (meio[i] >= 10) {
                                segura = meio[i];
                                meio[i] = (meio[i] % 10);
                                vaium = true;
                                vaiquanto = (segura / 10);
                            } else {
                                vaium = false;
                            }
                            break;
                        case 4:
                            meio[i] = meio[i] + 4;
                            if (meio[i] >= 10) {
                                segura = meio[i];
                                meio[i] = (meio[i] % 10);
                                vaium = true;
                                vaiquanto = (segura / 10);
                            } else {
                                vaium = false;
                            }
                            break;
                        case 5:
                            meio[i] = meio[i] + 5;
                            if (meio[i] >= 10) {
                                segura = meio[i];
                                meio[i] = (meio[i] % 10);
                                vaium = true;
                                vaiquanto = (segura / 10);
                            } else {
                                vaium = false;
                            }
                            break;
                        case 6:
                            meio[i] = meio[i] + 6;
                            if (meio[i] >= 10) {
                                segura = meio[i];
                                meio[i] = (meio[i] % 10);
                                vaium = true;
                                vaiquanto = (segura / 10);
                            } else {
                                vaium = false;
                            }
                            break;
                        case 7:
                            meio[i] = meio[i] + 7;
                            if (meio[i] >= 10) {
                                segura = meio[i];
                                meio[i] = (meio[i] % 10);
                                vaium = true;
                                vaiquanto = (segura / 10);
                            } else {
                                vaium = false;
                            }
                            break;
                        case 8:
                            meio[i] = meio[i] + 8;
                            if (meio[i] >= 10) {
                                segura = meio[i];
                                meio[i] = (meio[i] % 10);
                                vaium = true;
                                vaiquanto = (segura / 10);
                            } else {
                                vaium = false;
                            }
                            break;
                    }
                }
                k--;
                i++;
                if (qualmaior >= l) {
                    j = pilha1[k];
                } else {
                    j = pilha2[f];
                }
            }
            if ( y > 1){
                parcial = somar2(pilha1, pilha2, parcial, y);
            }
            f--;
            y++;
        }
        primeiro = true;


        //inverte meio para multiplicação (que vai ser mostrada na view)
        k = meio.length - 1;
        for (i = 0; i < meio.length; i++) {
            multiplicacao = String.valueOf(meio[k]);
            k--;
        }
        return multiplicacao;

    }

    public int[] somar2( int []pilha1, int []pilha2, int []meio, int pular){
        int segura;
        y = pular;
        k = 29;
        i = 0;
        l = pilha2.length;
        int h;
        qualmaior = pilha1.length;
        if (qualmaior >= l) {
            j = pilha1[k];
        } else {
            j = pilha2[k];
        }
        //vê quantas casas é preciso pular na soma das multiplicações um a um
        while (y > 0){
            segura = pilha2[k];
            pilha2[k] = 0;
            k--;
            h = k;
            while (segura != -1){
                pilha2[h] = segura;
                h--;
                segura = pilha2[h];
            }
            y--;
        }
        k = 29;
        //realiza a soma das pilhas
        while (j != -1) {
            if (pilha1[k] != -1 && pilha2[k] != -1) {
                if (pilha1[k] + pilha2[k] < 10) {
                    meio[i] = pilha1[k] + pilha2[k];
                    if (vaium) {
                        meio[i] = meio[i] + 1;
                        if (meio[i] == 10) {
                            meio[i] = 0;
                            vaium = true;
                        } else {
                            vaium = false;
                        }
                    }
                } else {
                    meio[i] = ((pilha1[k] + pilha2[k]) % 10);
                    if (vaium) {
                        meio[i] = meio[i] + 1;
                    }
                    vaium = true;
                }
            } else {
                if (qualmaior >= l) {
                    meio[i] = pilha1[k];
                } else {
                    meio[i] = pilha2[k];
                }
                if (vaium) {
                    meio[i] = meio[i] + 1;
                    if (meio[i] == 10) {
                        meio[i] = 0;
                        vaium = true;
                    } else {
                        vaium = false;
                    }
                }
            }
            k--;
            i++;
            if (qualmaior >= l) {
                j = pilha1[k];
            } else {
                j = pilha2[k];
            }
        }

        //inverte meio para soma (que vai ser mostrada na view)
        k = meio.length - 1;
        for (i = 0; i < meio.length; i++) {
            soma = String.valueOf(meio[k]);
            k--;
        }
        return meio;
    }

}


