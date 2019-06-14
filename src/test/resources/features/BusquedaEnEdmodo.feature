#language: es
@development
@ui
Característica: Hago una busqueda en el buscador de Edmodo

  Esquema del escenario: Escenario: Introduciremos la palabara "Edwin" en el buscador y veremos los resultados

    Dado Me logueo exitosamente en Edmodo
    Cuando Introduzco <busqueda> en el buscador
    Entonces Compruebo las diferentes pestañas y sus resutados

    Ejemplos:
    |busqueda|
    |Edwin   |
    |Manuel Torres Molina|