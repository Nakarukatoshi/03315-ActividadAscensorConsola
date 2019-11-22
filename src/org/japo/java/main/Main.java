/* 
 * Copyright 2019 Javier Monterde - javier.monterde.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Javier Monterde - javier.monterde.alum@iescamp.es
 */
public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {
        //Constantes
        final int MIN_PLANTA = 1;
        final int MAX_PLANTA = 10;
        final int NUM_PERS = 4;

        //Variables
        int personaActual;
        int planta;
        boolean exitLoop;

        //Bucle principal
        for (personaActual = 0; personaActual < NUM_PERS; personaActual++) {
            //Reiniciamos el bucle de usuarios
            exitLoop = false;

            //Bucle de usuarios
            do {
                try {
                    //Pedimos la planta
                    System.out.printf("Usuario número .................: %1d%n",
                            personaActual + 1);
                    System.out.printf("Introduzca la planta deseada ...: ");
                    planta = SCN.nextInt();

                    //Comprobamos que el valor de la planta es válido
                    if (planta >= MIN_PLANTA && planta <= MAX_PLANTA) {
                        //Si lo es, le diremos la planta que decidió
                        System.out.printf("Usted selecionó la planta ......: "
                                + "%02d.%n", planta);

                        //y pasaremos al siguiente usuario
                        exitLoop = true;
                    } else {
                        //Si no lo es, le avisaremos y repetiremos el bucle
                        System.out.printf("ERROR: "
                                + "La planta introducida no existe.%n"
                                + "Por favor, vuelva a intentarlo.%n");
                    }
                } catch (Exception e) {
                    //Si el usuario intenta liarla, se lo evitaremos
                    System.out.printf("ERROR: El valor introducido no es un "
                            + "número entero.%n");
                } finally {
                    //¡LIMPIA SIEMPRE EL BÚFER, CEPORRO!
                    SCN.nextLine();
                }
            } while (exitLoop == false);
        }
    }
}
