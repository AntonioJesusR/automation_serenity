#language: es
@development
  @ui

  Característica: Me quiero loguear en el edmodo con mis credenciales.

    Escenario: Puedo acceder a mi perfil de Edmodo
    Dado Navego a la pagina web de Edmodo
    Cuando Introduzco mi usuario y mi contraseña correctamente
    Entonces Entro en la aplicacion de Edmodo

    Escenario: No puedo acceder a mi perfil de Edmodo y me lo notifica
      Dado Navego a la pagina web de Edmodo
      Cuando Introduzco mi usuario y mi contraseña incorrectamente
      Entonces Aparecerá un mensaje de error

    Escenario: Puedo iniciar sesiones en dos pestañas distintas
      Dado Navego a la pagina web de Edmodo
      Cuando Introduzco mi usuario y mi contraseña incorrectamente
      Entonces Aparecerá un mensaje de error