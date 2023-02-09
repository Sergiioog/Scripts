# ACTIVIDAD SCRIPTS BASICOS

##### 1. Y 2. RECIBIR UN NÚMERO ENTERO POR TECLADO Y DECIR SI ES POSITIVO O NEGATIVO
```bash 
#!/bin/bash
echo "Introduce un número entero: "
read numeroEntero
if [ ${numeroEntero} -gt -1 ]
then
        echo "El número ${numeroEntero} es positivo"
else
        echo "El número ${numeroEntero} es negativo"
fi
```
##### 3. RECIBIR UN NUMERO ENTERO POR TECLADO Y DECIR SI ES IGUAL A 0
```bash 
#!/bin/bash
echo "Introduce un numero entero: "
read numeroEntero
if [ ${numeroEntero} == 0 ]
then
        echo "El número ${numeroEntero} es igual a 0"
else
        echo "El numero ${numeroEntero} no es igual a 0"
fi
```

##### 4. RECIBIR UN NUMERO ENTERO POR TECLADO Y DECIR SI ES POSITIVO, NEGATIVO O 0
```bash 
#!/bin/bash
echo "Introduce un número entero: "
read numeroEntero
if [ ${numeroEntero} -gt 0 ]
then
        echo "El número entero ${numeroEntero} es mayor que 0"
elif [ ${numeroEntero} == 0 ]
then
        echo "El número entero ${numeroEntero} es igual a 0"
else
        echo "El número entero ${numeroEntero} es menor a 0"
fi
``` 
##### 5. COMPROBAR SI EL NÚMERO DE PARÁMETROS INTRODUCIDOS ES IGUAL A 3, EN EL CASO DE QUE SEA OTRO NÚMERO SE MOSTRARÁ UN MENSAJE DE ERROR
```bash 
#!/bin/bash
if [ ${#} == 3 ]
then
        echo "El número de parámetros es igual a 3"
else
        echo "El número de parámetros no es igual a 3"
fi
```

##### 6. RECIBIR DOS NÚMEROS POR PARÁMETROS Y LO SUMA. EN CASO DE QUE EL NÚMERO DE PARÁMETROS SEA INCORRECTO SE MOSTRARÁ UN MENSAJE DE ERROR
```bash 
#!/bin/bash
suma=$(($1 + $2))
if [ ${#} == 2 ]
then
        echo "La suma de $1 + $2 es igual a $suma"
else
        echo "El número de parámetros es incorrecto"
fi
```

##### 7. RECIBIR 3 PARÁMETROS. EN EL CASO DE QUE RECIBA UN NÚMERO DIFERENTE MOSTRARÁ UN MENSAJE DE ERROR.
##### LOS DOS PRIMEROS SERÁN DOS NÚMEROS Y EL TERCERO SERÁ UNO DE LOS SIGUIENTES SÍMBOLOS "+""-""X""/",
##### DEPENDIENDO DEL TERCER PARÁMETRO INTRODUCIDO SE REALIZARÁ LA OPERACIÓN. EN EL CASO DE QUE SE INTRODUZCA UN SIMBOLO DIFERENTE PRESENTARÁ UN MENSAJE INDICANDO LAS OPCIONES CORRECTAS.
```bash 
#!/bin/bash
suma=$(($1 + $2))
resta=$(($1 - $2))
multiplicacion=$(($1 * $2))
division=$(($1 / $2))
if ! [[ $1 =~ ^[0-9]$ ]]
then
        echo "No es un número"
elif [ ${#} != 3 ]
then
        echo "Número de parámetros incorrectos"
else
case $3 in
+*)
        echo "La suma de los números $1 + $2 es igual a $suma"
;;
-*)
        echo "La resta de los números $1 - $2 es igual a $resta"
        ;;
x*)
        echo "La multiplicación de los números $1 * $2 es igual a $multiplicacion"
;;
/*)
        echo "La división de los números $1 / $2 es igual a $division"
;;
*)
        echo "ERROR: Símbolo no reconocido, escoja de entre +,-,*,/"
esac
fi
```
##### 8. RECIBIR LA RUTA DE UN FICHERO E INDICAR SI EXISTE
```bash 
#!/bin/bash
if [ -d $1 ]
then
        echo "$1 Es un directorio"
else
        echo "$1 No es un directorio"
fi
```

##### 9. RECIBIR LA RUTA DE UN FICHERO E INDICAR SI EXISTE
```bash 
#!/bin/bash
if [ -d $1 ]
then
        echo "$1 Es un directorio"
elif [ -f $1 ]
then
        echo "$1 Es un fichero"
else
        echo "No existe"
fi
```

##### 10. RECIBIR LA RUTA DE UN FICHERO Y DECIR QUE PERMISOS TIENE
```bash 
#!/bin/bash
if ! [ -r $1 ]
then
        echo "El fichero $1 no tiene permisos de lectura"
elif ! [ -w $1 ]
then
        echo "El fichero $1 no tiene permisos de escritura"
elif ! [ -x $1 ]
then
        echo "El fichero $1 no tiene permisos de ejecucion"#
else
        echo "El fichero $1 tiene todos los permisos"
fi
```

##### 11. IMPRIMIR POR PANTALLA 50 VECES LA PALABRA HOLA
```bash 
#!/bin/bash
for i in {1..50}; do
        echo "Hola número $i"
done
```

##### 12.LEER UNA PALABRA POR TECLADO Y MOSTRARLA POR CONSOLA. DEBE REALIZAR ESTA OPERACIÓN 10 VECES. 
```bash 
#!/bin/bash
echo "Introduce una palabra: "
read palabra
if [[ $palabra =~ ^[0-9]$ ]]
then
        echo "Lo introducido no es una palabra"
else
        for i in {1..10}; do
                echo "$palabra numero $i"
        done
fi
```

##### 13. RECIBIR UN NÚMERO POR PARÁMETRO, Y SE IMPRIMIRÁ LA PALABRA HOLA EL NUMERO DE VECES QUE SE HAYA INTRODUCIDO
```bash 
#!/bin/bash
if ! [[ $1 =~ ^[0-9]+$ ]]
then
       echo "No es un número"
       exit;
fi
num=${1}
for (( i=1; i<=$1; i++ ))
do
        echo "Hola, número $i"
done
```

##### 14. PASAR UN NÚMERO COMO PARÁMETRO Y EL PROGRAMA IMPRIMIRA NUMEROS DEL 0 A N POR PANTALLA
```bash 
#!/bin/bash
if ! [[ $1 =~ ^[0-9]+$ ]]
then
       echo "No es un número"
       exit;
fi
num=${1}
for (( i=0; i<=$1; i++ ))
do
        echo "Número $i"
done
```

##### 15. RECIBIR UN NÚMERO POR N PARÁMETRO. EL PROGRAMA SUMARÁ TODOS LOS NUMEROS ENTRE 1 Y N.
```bash 
#!/bin/bash
if ! [[ $1 =~ ^[0-9]+$ ]]
then
       echo "No es un número"
       exit;
fi
num=${1}
resultdo=0
for (( i=1; i<=$1; i+=1 ))
do
        resultado=$(($resultado+$i))
done
echo "El resultado es $resultado"
```

##### 16. RECIBIR DOS NUMERO POR PARAMETROS. EL PROGRAMA HARÁ QUE EL PRIMER PARAMETRO TOME EL VALOR DEL SEGUNDO Y EL SEGUNDO TOME VALOR DEL PRIMERO
```bash 
#!/bin/bash
if [ ${#} != 2 ]
then
        echo "Cantidad inválida"
        exit;
fi
if ! [[ $1 =~ ^[0-9]+$ || $2 =~ ^[0-9]+$  ]]
then
        echo "No es una palabra"
        exit;
fi
a=$(($2))
b=$(($1))
echo "EL valor del parametro 1 = $a  mientras que el valor del parametro 2 = $b"
```

##### 17. PROGRAMA QUE LEA LAS PALABRAS HASTA QUE SE ESCRIBA :Q
```bash 
#!/bin/bash
echo "Introduce una serie de palabras"
read palabrasej
palabras=${palabrasej}
while [ ${palabras} != "Q" ]
do
        read palabras
done
```

##### 18. PROGRAMA QUE LEA LAS PALABRAS HASTA QUE SE ESCRIBA :Q Y SE GUARDE EN UN FICHERO
```bash 
#!/bin/bash
echo "Introduce una serie de palabras"
read palabrasej
palabras=${palabrasej}
while [ ${palabras} != "Q" ]
do
       read palabras
       echo $palabras >> palabras.txt
done
```

##### 19. PROGRAMA QUE LEA PALABRAS HASTA QUE SE ESCRIBA :Q Y SE GUARDE EN UN FICHERO DE FORMA ORDENADA
```bash 
#!/bin/bash
echo "Introduce una serie de palabras"
read palabrasej
palabras=${palabrasej}
while [ ${palabras} != "Q" ]
do
       read palabras
       echo $palabras >> palabras1.txt
       sort -o palabras1.txt palabras1.txt
done
```

##### 20. REALIZA UN PROGRAMA QUE TE SOLICITE UN NÚMERO Y COMPRUEBE SI SE ENCUENTRA EN UN ARCHIVO.TXT
```bash 
#!/bin/bash
echo "Introduce un número: "
read numero
if ! [[ $numero =~ ^[0-9]+$ ]]
then
        echo "Números introducidos no válidos"
        exit;
fi
if ! [ ${#} != 1 ]
then
        echo "Cantidad de parámetros introducidos no válidos"
        exit;
fi
for i in `cat archivo.txt`
do
        if [ $i -eq $numero ]
        then
                echo "Se encuentra en el fichero"
                exit 0
        fi
done
echo "El número no existe en el fichero"
```
