package com.example.calculadoracomplicada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    Button ativar;
    TextView resultado;
    EditText inserir;
    Float[] pilha1;
    Float[] pilha2;
    Float[] soma;
    Float[] multiplicacao;
    Float[] meio;
    String[] convercao;
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
            pilha1[i] = (float) -1;
            pilha2[i] = (float) -1;
        }
    }


    public void ir(View f) {

        i = Integer.parseInt(String.valueOf(inserir.getText()));
        k = 0;
        convercao[] =Integer.toString(i);
        try {
            for (j = 0; j < 30; j++) {
                convercao[j] = convercao[j];
                k++;
            }
        } catch (Exception e) {
            l = k;
        }
        if (primeiro) {
            for (j = 29; j < (29 - l); j--) {
                qualmaior = l;
                pilha1[j] = Float.parseFloat(convercao[j]);
            }
            primeiro = false;
        } else {
            for (j = 29; j < (29 - l); j--) {
                pilha2[j] = Float.parseFloat(convercao[j]);
            }


            //soma//////////////////////////////////////////////////////////////////////
            k = 29;
            i = 0;
            if (qualmaior >= l) {
                j = Integer.parseInt(String.valueOf(pilha1[k]));
            } else {
                j = Integer.parseInt(String.valueOf(pilha2[k]));
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
                                meio[i] = Float.parseFloat("0");
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
                                meio[i] = Float.parseFloat("0");
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
                    j = (Integer)pilha1[k];
                } else {
                    j = Integer.parseInt(pilha2[k]);
                }
            }

            //inverte meio para soma (que vai ser mostrada na view)
            k = meio.length - 1;
            for (i = 0; i < meio.length; i++) {
                soma[i] = meio[k];
                k--;
            }


            //multiplicação///////////////////////////////////////////////////////////////////////
            k = 29;
            i = 0;
            if (qualmaior >= l) {
                j = Integer.parseInt(pilha1[k]);
            } else {
                j = Integer.parseInt(pilha2[k]);
            }
            while (j != -1) {
                if (pilha1[k] != -1 && pilha2[k] != -1) {
                    if (pilha1[k] * pilha2[k] < 10) {
                        meio[i] = pilha1[k] * pilha2[k];
                        if (vaium) {
                            switch (vaiquanto) {
                                case :
                                    1
                                    meio[i] = meio[i] + 1
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    2
                                    meio[i] = meio[i] + 2
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    3
                                    meio[i] = meio[i] + 3
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    4
                                    meio[i] = meio[i] + 4
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    5
                                    meio[i] = meio[i] + 5
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    6
                                    meio[i] = meio[i] + 6
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    7
                                    meio[i] = meio[i] + 7
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    8
                                    meio[i] = meio[i] + 8
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
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
                            if (vaium) {
                                switch (vaiquanto) {
                                    case :
                                        1
                                        meio[i] = meio[i] + 1
                                        if (meio[i] >= 10) {
                                            segura = Integer.parseInt(meio[i]);
                                            meio[i] = (meio[i] % 10);
                                            vaium = true;
                                            vaiquanto = (segura / 10);
                                        } else {
                                            vaium = false;
                                        }
                                        break;
                                    case :
                                        2
                                        meio[i] = meio[i] + 2
                                        if (meio[i] >= 10) {
                                            segura = Integer.parseInt(meio[i]);
                                            meio[i] = (meio[i] % 10);
                                            vaium = true;
                                            vaiquanto = (segura / 10);
                                        } else {
                                            vaium = false;
                                        }
                                        break;
                                    case :
                                        3
                                        meio[i] = meio[i] + 3
                                        if (meio[i] >= 10) {
                                            segura = Integer.parseInt(meio[i]);
                                            meio[i] = (meio[i] % 10);
                                            vaium = true;
                                            vaiquanto = (segura / 10);
                                        } else {
                                            vaium = false;
                                        }
                                        break;
                                    case :
                                        4
                                        meio[i] = meio[i] + 4
                                        if (meio[i] >= 10) {
                                            segura = Integer.parseInt(meio[i]);
                                            meio[i] = (meio[i] % 10);
                                            vaium = true;
                                            vaiquanto = (segura / 10);
                                        } else {
                                            vaium = false;
                                        }
                                        break;
                                    case :
                                        5
                                        meio[i] = meio[i] + 5
                                        if (meio[i] >= 10) {
                                            segura = Integer.parseInt(meio[i]);
                                            meio[i] = (meio[i] % 10);
                                            vaium = true;
                                            vaiquanto = (segura / 10);
                                        } else {
                                            vaium = false;
                                        }
                                        break;
                                    case :
                                        6
                                        meio[i] = meio[i] + 6
                                        if (meio[i] >= 10) {
                                            segura = Integer.parseInt(meio[i]);
                                            meio[i] = (meio[i] % 10);
                                            vaium = true;
                                            vaiquanto = (segura / 10);
                                        } else {
                                            vaium = false;
                                        }
                                        break;
                                    case :
                                        7
                                        meio[i] = meio[i] + 7
                                        if (meio[i] >= 10) {
                                            segura = Integer.parseInt(meio[i]);
                                            meio[i] = (meio[i] % 10);
                                            vaium = true;
                                            vaiquanto = (segura / 10);
                                        } else {
                                            vaium = false;
                                        }
                                        break;
                                    case :
                                        8
                                        meio[i] = meio[i] + 8
                                        if (meio[i] >= 10) {
                                            segura = Integer.parseInt(meio[i]);
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
                        vaium = true;
                    }
                } else {
                    if (qualmaior >= l) {
                        meio = pilha1[k];
                        if (vaium) {
                            switch (vaiquanto) {
                                case :
                                    1
                                    meio[i] = meio[i] + 1
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    2
                                    meio[i] = meio[i] + 2
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    3
                                    meio[i] = meio[i] + 3
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    4
                                    meio[i] = meio[i] + 4
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    5
                                    meio[i] = meio[i] + 5
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    6
                                    meio[i] = meio[i] + 6
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    7
                                    meio[i] = meio[i] + 7
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    8
                                    meio[i] = meio[i] + 8
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
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
                        meio = pilha2[k];
                        if (vaium) {
                            switch (vaiquanto) {
                                case :
                                    1
                                    meio[i] = meio[i] + 1
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    2
                                    meio[i] = meio[i] + 2
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    3
                                    meio[i] = meio[i] + 3
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    4
                                    meio[i] = meio[i] + 4
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    5
                                    meio[i] = meio[i] + 5
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    6
                                    meio[i] = meio[i] + 6
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    7
                                    meio[i] = meio[i] + 7
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
                                        meio[i] = (meio[i] % 10);
                                        vaium = true;
                                        vaiquanto = (segura / 10);
                                    } else {
                                        vaium = false;
                                    }
                                    break;
                                case :
                                    8
                                    meio[i] = meio[i] + 8
                                    if (meio[i] >= 10) {
                                        segura = Integer.parseInt(meio[i]);
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
                    j = Integer.parseInt(pilha1[k]);
                } else {
                    j = Integer.parseInt(pilha2[k]);
                }
            }
            primeiro = true;


            //inverte meio para mulriplicação (que vai ser mostrada na view)
            k = meio.length - 1;
            for (i = 0; i < meio.length; i++) {
                multiplicacao[i] = meio[k];
                k--;
            }
        }

    }

    public void mostrar() {
        resultado.setText("Soma: " + soma.toString() + "\nMultiplicação", multiplicacao.toString());
    }
}
