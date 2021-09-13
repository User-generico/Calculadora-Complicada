package com.example.calculadoracomplicada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button ativar;
    TextView resultado;
    EditText inserir;
    int [] pilha1 = new int [30];
    int [] pilha2 = new int [30];
    int [] soma = new int [30];
    int [] multiplicacao = new int [30];
    int [] meio = new int [30];
    String convercao;
    Integer i, j, k, l, qualmaior, vaiquanto, segura;
    Boolean primeiro = true, vaium = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ativar = findViewById(R.id.ativar);
        resultado = findViewById(R.id.resultado);
        inserir = findViewById(R.id.inserir);

        for (i = 0; i < 30; i++) {
            pilha1[i] = -1;
            pilha2[i] = -1;
            soma[i] = -1;
            multiplicacao[i] = -1;
        }
    }


    public void ir(View f) {

        convercao = String.valueOf(inserir.getText());
        k = 29;
        l = convercao.length();
        if (primeiro) {
            for (j = 0; j <= l; j--) {

                pilha1[k] = convercao.charAt(j);
                k--;
            }
            qualmaior = l;
            primeiro = false;
        } else {
            for (j = 29; j < l; j--) {
                pilha2[j] = convercao.charAt(j);
                k--;
            }
            somar();
            multiplicar();
            mostrar();
        }
    }

    public void mostrar() {
        resultado.setText("Soma: \n Multiplicação" );
    }

    public void somar(){
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
                    meio[i] = pilha2[k];
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
            soma[i] = meio[k];
            k--;
        }
    }

    public void multiplicar(){
        //multiplicação///////////////////////////////////////////////////////////////////////
        k = 29;
        i = 0;
        if (qualmaior >= l) {
            j = (pilha1[k]);
        } else {
            j = (pilha2[k]);
        }
        while (j != -1) {
            if (pilha1[k] != -1 && pilha2[k] != -1) {
                if (pilha1[k] * pilha2[k] < 10) {
                    meio[i] = pilha1[k] * pilha2[k];
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
                } else {
                    meio[i] = ((pilha1[k] * pilha2[k]) % 10);
                    vaiquanto = ((pilha1[k] * pilha2[k]) / 10);
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
                }
            } else {
                if (qualmaior >= l) {
                    meio[i] = pilha1[k];
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
                } else {
                    meio[i] = pilha2[k];
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
        primeiro = true;


        //inverte meio para multiplicação (que vai ser mostrada na view)
        k = meio.length - 1;
        for (i = 0; i < meio.length; i++) {
            multiplicacao[i] = meio[k];
            k--;
        }
    }
}


