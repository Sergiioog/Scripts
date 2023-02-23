#!/bin/bash

function funcionInstalacion {

    echo "HA SELECCIONADO LA OPCION INSTALACION"
    
    echo "Has seleccionado la creación de un Directorio"
    
    echo "Introduzca el nombre del directorio: "
    
    read directorio

    if ! [[ -d ${directorio} ]] 
    
    then
    
        mkdir ${directorio}
    
    else
    
        echo "El directorio ya existe" 
        exit
    
    fi



    echo "Introduzca el nombre del grupo: "
    read nombreGrupo
    
    grep -q -E ${nombreGrupo} /etc/group
    
    if [[ $? -eq 0 ]]
    then
        echo "El grupo ya existe"
        exit
    
    else
        groupadd ${nombreGrupo}

    fi

    echo "Introduce un nombre de usuario: "
    read nombreUsuario

    grep -q -E ${nombreUsuario} /etc/group
    if [[ ${nombreUsuario} -eq 0 ]]
    then
        echo "El nombre ya existe"
        exit
    
    else
        useradd -g ${nombreGrupo} -s /bin/bash ${nombreUsuario}
    fi
        
    
    if [[ -h /usr/bin/java ]]
    then
        echo "Se ha creado correctamente"
        cp pizarra.java ${directorio}   
    else
        echo "No se ha podido crear"
    fi


}
function funcionEjecucion { 
    
    echo "HA SELECCIONADO LA OPCION EJECUCION"
    echo "Introduce el nombre del archivo de texto" 
    read archivo

    if ! [[ -f ${archivo} ]]
    then
        echo "El archivo no existe"
    else
        chmod +x pizarra.java
        echo "Seleccione el color que quiere: R/G/Y"
        read color

        if [[ $color == "R" ]]
        then
            cat pizarra.java
            exit
        elif [[ $color == "G" ]]
        then
            pizarra.java
            exit
        elif [[ $color == "Y" ]]
        then
            pizarra.java
        else
            echo "No se puede ejecutar"
        
        fi
    fi
    

}

function funcionDesinstalacion {
    
    echo "HA ELEGIDO LA FUNCION DESINSTALACION "
    echo "Estás seguro de eliminar todo lo realizado?: "
    read respuesta

    if [[ ${respuesta} == "SI" ]]
    then
        echo "Última advertencia, estás seguro?: "
        read respuestaDefinitiva

        if [[ ${respuestaDefinitiva} == "SI"  ]]
        then
            rm -r funcionInstalacion
            tail 
        else
            exit
        fi
    else
        exit
    fi

}

function funcionAyuda {
    
    echo "  ****MENU****"
    echo "----------------"
    echo "  1.INSTALACION "
    echo "----------------"
    echo "  2.EJECUCION"
    echo "----------------"
    echo "3.DESINSTALACION"
    echo "----------------"

    echo "Introduzca el número de  la opción que desea utilizar"
    read opcion
    if [[ ${opcion} == 1 ]]
    then
        funcionInstalacion
        exit
    elif [[ ${opcion} == 2 ]]
    then
        funcionEjecucion
        exit
    elif [[ ${opcion} == 3 ]]
    then
        funcionDesinstalacion
        exit
    else
        echo "Parámetro inválido"
    fi

}

if [[ ${#} -eq 0 ]]
then
    funcionAyuda
    exit
fi

if ! [ ${#} == 1 ]

then

    echo "Número de parámetros inválido"
    exit

else

    if [[ ${1} == "Instalacion" ]]
    then

        funcionInstalacion
        exit        
    
    elif [[ ${1} == "Ejecucion" ]]
    
    then
        funcionEjecucion
        exit

    elif [[ ${1} == "Desinstalacion" ]]
    
    then
        funcionDesinstalacion
        exit
    elif [[ ${1} == "Ayuda" ]]
    then
        funcionAyuda
        exit
    else
        echo "El parámetro ${1} no está entre las opciones"
    fi
fi  

