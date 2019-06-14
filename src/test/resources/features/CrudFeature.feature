#language: es
@development
@backend
@ui
Característica: Hago llamadas a endpoints y compruebo que estan bien

  Escenario: : Introduciremos un usuario por la llamada al endpoint

    Dado Que lanzo la petición de agregar usuario
    Entonces  Compruebo que la respuesta será exitosa


  Escenario: : Quiero eliminar el pedido que he realizado anteriormente

    Dado Que lanzo la petición de borrar usuario
    Entonces  Compruebo que la respuesta será exitosa