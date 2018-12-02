# APP PARA CONTROL DE ORDENES DE SERVICIO - SERVICENTRO "GABRIEL"
---
**INTEGRANTES**
* HUERTO VIZA MANUEL ALEJANDRO
* PARRA CALLE DAVID ALEXANDER
* REQUENA TRONCOS RAFAEL ANGEL
---
**INDICE**
1. Prototipos
2. Historias de Usuario
3. Diseño de su base de datos estructurada
4. Diseño de su base de datos en firebase, explicar el proceso y por qué se desmoralizó de esa forma (Debe estar alineada a su interfaz, como el ejemplo de twitter)
5. Problemas encontrados en el desarrollo
6. Screenshots del proyecto final
7. Cuadro resumen de historias de usuario, puntos, y objetivo logrado
---
1. Prototipos
    > Login

    ![](https://i.imgur.com/aZVXWLX.jpg)


    > Main Principal

    ![](https://i.imgur.com/wPhHM8a.jpg)


    > Detalles Cliente

    ![](https://i.imgur.com/4JcOo9I.jpg)
   

    > Clientes Adapter

    ![](https://i.imgur.com/dWX7iws.jpg)


    > Lista Clientes

    ![](https://i.imgur.com/2qqwzFl.jpg)


2. Historias de Usuario

    | ID Historia | 00001 | 
    | -------- | -------- | 
    | **Responsable**     | Responsable 1     | 
    | **Historia de Usuario**     | Login del Sistema     | 
    | **Rol**     | Tecnico, Recepcionista     | 
    | **Descripcion**     |      El usuario podrá ingresar al sistema y utilizar las funcionalidades.    | 
    | **Criterios de Aceptacion**     | El proceso concluirá cuando el sistema me muestre un mensaje de login exitoso. | 
    | **Importancia**     | Alta     |
    | **Riesgo de Desarrollo**     | Alto     |
    | **Puntos**     | 3     |
    | **Terminado**     | SI     |
    
    | **ID Historia** | 00002 | 
    | -------- | -------- | 
    | **Responsable**     | Responsable 1     | 
    | **Historia de Usuario**     | Registro de OS     | 
    | **Rol**     | Tecnico     | 
    | **Descripcion**     |      El técnico podrá registrar las OS de todos los vehículos que llegan al taller para obtener algún servicio, así se podrá registrar los datos del vehículo (si es primera vez). Se podrá generar reportes en base a todas las OS registradas.    | 
    | **Criterios de Aceptacion**     | El proceso concluirá cuando el sistema me emita un documento del registro de la OS. | 
    | **Importancia**     | Alta     |
    | **Riesgo de Desarrollo**     | Alto     |
    | **Puntos**     | 10 h     |
    | **Terminado**     | NO     |
    
    | ID Historia | 00003 | 
    | -------- | -------- | 
    | **Responsable**     | Responsable 2     | 
    | **Historia de Usuario**     | Modificación de OS     | 
    | **Rol**     | Tecnico, Recepcionista     | 
    | **Descripcio**n     |      Se podrá modificar la información de una OS que se haya registrado, ya que puede haber algún error al registrar una OS correspondiente.    | 
    | **Criterios de Aceptacion**     | El proceso concluirá cuando el sistema me emita un documento del registro de la OS. | 
    | **Importancia**     | Alta     |
    | **Riesgo de Desarrollo**     | Alto     |
    | **Puntos**     | 8     |
    | **Terminado**     | NO     |
    
    | ID Historia | 00004 | 
    | -------- | -------- | 
    | **Responsable**     | Responsable 3     | 
    | **Historia de Usuario**     | Facturación de OS     | 
    | **Rol**     | Recepcionista/Cajera     | 
    | **Descripcion**     |      La cajera/recepcionista podrá realizar la facturación de las OS que se realicen, y así poder registrar el movimiento en caja.    | 
    | **Criterios de Aceptacion**     | Al registrar el cobro de la factura se deberá emitir el comprobante de pago correspondiente. | 
    | **Importancia**     | Alta     |
    | **Riesgo de Desarrollo**     | Alto     |
    | **Puntos**     | 6      |
    | **Terminado**     | NO    |
    
    | ID Historia | 00005 | 
    | -------- | -------- | 
    | **Responsable**     | Responsable 2     | 
    | **Historia de Usuario**     | Consulta de OS    | 
    | **Rol**     | Recepcionista / Técnico     | 
    | **Descripcion**     |      El técnico o recepcionista podrá visualizar los datos de una OS registrada, facturada o cancelada. Servirá para obtener reportes respectivos a la realización de los diferentes servicios.    | 
    | **Criterios de Aceptacion**     | El proceso concluirá cuando el sistema me emita un documento del registro de la OS. | 
    | **Importancia**     | Alta     |
    | **Riesgo de Desarrollo**     | Alto     |
    | **Puntos**     | 10 h     |
    | **Terminado**     | NO     |
    
    | ID Historia | 00006 | 
    | -------- | -------- | 
    | **Responsable**     | Responsable 2    | 
    | **Historia de Usuario**     | Registro datos de clientes     | 
    | **Rol**     | Recepcionista     | 
    | **Descripcion**     |      La recepcionista podrá registrar los datos del cliente, para una búsqueda y registro más rápido al momento de generar una OS en el momento o en futuras atenciones.    | 
    | **Criterios de Aceptacion**     | El proceso concluirá cuando al momento de realizar una consulta de datos del cliente, me devuelve los datos registrados previamente. | 
    | **Importancia**     | Media     |
    | **Riesgo de Desarrollo**     | Bajo     |
    | **Puntos**     | 3     |
    | **Terminado**     | SI     |
    
    | ID Historia | 00007 | 
    | -------- | -------- | 
    | **Responsable**     | Responsable 3     | 
    | **Historia de Usuario**     | Modificación datos de clientes     | 
    | **Rol**     |Recepcionista     | 
    | **Descripcion**     |      La recepcionista podrá modificar los datos del cliente, en caso que el cliente haya cambiado de auto o hubiera un dato mal registrado.    | 
    | **Criterios de Aceptacion**     | El proceso concluirá cuando al momento de realizar una consulta de datos del cliente, me devuelve los datos actualizados corregidos. | 
    | **Importancia**     | Media     |
    | **Riesgo de Desarrollo**     | Bajo     |
    | **Puntos**     | 3    |
    | **Terminado**     | SI     |
    
    | ID Historia | 00008 | 
    | -------- | -------- | 
    | **Responsable**     | Responsable 2    | 
    | **Historia de Usuario**     | Visualización datos de clientes     | 
    | **Rol**     | Recepcionista     | 
    | **Descripcion**     |      El usuario podrá visualizar los datos completos registrados del cliente que se seleccione.    | 
    | **Criterios de Aceptacion**     | El proceso concluirá cuando al seleccionar un cliente, me devuelve los datos almacenados. | 
    | **Importancia**     | Baja     |
    | **Riesgo de Desarrollo**     | Bajo     |
    | **Puntos**     | 3     |
    | **Terminado**     | SI     |
    
    | ID Historia | 00009 | 
    | -------- | -------- | 
    | **Responsable**     | Responsable 2     | 
    | **Historia de Usuario**     | Registro de datos de Servicios     | 
    | **Rol**     | Recepcionista     | 
    | **Descripcion**     |      El usuario registrara los datos de un nuevo servicio.    | 
    | **Criterios de Aceptacion**     | El proceso concluirá cuando al momento de guardar los datos, me muestre un mensaje satisfactorio y me retorne a la lista de servicios. | 
    | **Importancia**     | Media     |
    | **Riesgo de Desarrollo**     | Medio     |
    | **Puntos**     | 5     |
    | **Terminado**     | SI     |
    
    | ID Historia | 00010 | 
    | -------- | -------- | 
    | **Responsable**     | Responsable 1     | 
    | **Historia de Usuario**     | Modificación datos de servicios     | 
    | **Rol**     | Recepcionista     | 
    | **Descripcion**     |      El usuario podrá modificar los datos de un servicio existente.    | 
    | **Criterios de Aceptacion**     | El proceso concluirá cuando al momento de actualizar los datos, me muestre un mensaje satisfactorio y me retorne a la lista de servicios. | 
    | **Importancia**     | Medio     |
    | **Riesgo de Desarrollo**     | Medio     |
    | **Puntos**     | 5     |
    | **Terminado**     | SI     |
    
    | ID Historia | 00011 | 
    | -------- | -------- | 
    | **Responsable**     | Responsable 1    | 
    | **Historia de Usuario**     | Visualización datos de servicios     | 
    | **Rol**     | Recepcionista     | 
    | **Descripcion**     |      El usuario podrá visualizar los datos de un servicio registrado.    | 
    | **Criterios de Aceptacion**     | El proceso concluirá cuando al seleccionar un servicio, el sistema me muestre los datos. | 
    | **Importancia**     | Baja     |
    | **Riesgo de Desarrollo**     | Bajo     |
    | **Puntos**     | 3     |
    | **Terminado**     | SI     |
    
    | ID Historia | 00012 | 
    | -------- | -------- | 
    | **Responsable**     | Responsable 3     | 
    | **Historia de Usuario**     | Registro datos de vehículos  | 
    | **Rol**     | Recepcionista     | 
    | **Descripcion**     |      El usuario podrá registrar nuevos vehículos que lleguen a obtener servicios, asi como al cliente que le pertenece. | 
    | **Criterios de Aceptacion**     | El proceso concluirá cuando al momento de guardar los datos, me muestre un mensaje exitoso y me retorne a la lista de vehículos. | 
    | **Importancia**     | Media     |
    | **Riesgo de Desarrollo**     | Medio     |
    | **Puntos**     | 5     |
    | **Terminado**     | SI     |
    
    | ID Historia | 00013 | 
    | -------- | -------- | 
    | **Responsable**     | Responsable 3     | 
    | **Historia de Usuario**     | Modificación datos de vehículos     | 
    | **Rol**     | Recepcionista     | 
    | **Descripcion**     |      El usuario podrá modificar datos de vehículos, por errores al registrar.    | 
    | **Criterios de Aceptacion**     | El proceso concluirá cuando al momento de actualizar los datos, me muestre un mensaje exitoso y me retorne a la lista de vehículos. | 
    | **Importancia**     | Medio     |
    | **Riesgo de Desarrollo**     | Medio     |
    | **Puntos**     | 5     |
    | **Terminado**     | SI     |
    
    | ID Historia | 00014 | 
    | -------- | -------- | 
    | **Responsable**     | Responsable 3     | 
    | **Historia de Usuario**     | Visualización datos de vehículos  | 
    | **Rol**     | Recepcionista     | 
    | **Descripcion**     |      El usuario podrá visualizar los datos completos de los vehículos. | 
    | **Criterios de Aceptacion**     | El proceso concluirá cuando al momento de seleccionar un vehículo, el sistema me muestre los datos del vehículo. | 
    | **Importancia**     | Baja     |
    | **Riesgo de Desarrollo**     | Bajo     |
    | **Puntos**     | 3    |
    | **Terminado**     | SI     |
    
    | ID Historia | 00015 | 
    | -------- | -------- | 
    | **Responsable**     | Responsable 1     | 
    | **Historia de Usuario**     | Logout     | 
    | **Rol**     | Recepcionista/Tecnico     | 
    | **Descripcion**     |      El usuario podrá cerrar la sesión correspondiente en el sistema    | 
    | **Criterios de Aceptacion**     | El proceso concluirá cuando al hacer clic en el botón de logout, me re direccione a la pantalla de login. | 
    | **Importancia**     | Baja     |
    | **Riesgo de Desarrollo**     | Baja     |
    | **Puntos**     | 3   |
    | **Terminado**     | SI     |
    
3. Diseño de su base de datos estructurada

    ![](https://i.imgur.com/UylbipY.jpg)

4. Diseño de su base de datos en firebase, explicar el proceso y por qué se desmoralizó de esa forma (Debe estar alineada a su interfaz, como el ejemplo de twitter)

    ![](https://i.imgur.com/XLAKt92.jpg)


5. Problemas encontrados en el desarrollo

    * EL diseño de la base de datos no relacional
    * EL fronted del aplicativo comenzamos con diseño básico con algunas modificaciones en iconos.
    * Al realizar la actualización de un nodo principal en un nodo secundario
    * Hacer que el teclado no oculte los componentes en pantalla
     
6. Screenshots del proyecto final

    ![](https://i.imgur.com/jKrvPCl.jpg)
    
    ![](https://i.imgur.com/I2rSuYp.jpg)
    
    ![](https://i.imgur.com/iPEsgLZ.jpg)
    
    ![](https://i.imgur.com/aQcv9bb.jpg)
    
    ![](https://i.imgur.com/7EYFwoy.jpg)

7. Cuadro resumen de historias de usuario, puntos, y objetivo logrado

    | HISTORIAS DE USUARIO | PUNTOS | TERMINADO |
    | -------- | -------- | -------- |
    | Login sistema | 3     | SI     |
    | Registro de OS | 10     | NO     |
    | Modificación de OS | 8     | NO     |
    | Facturación de OS | 6     | NO     |
    | Consulta de OS     | 5     | NO     |
    | Registro datos de clientes     | 3     | NO     |
    | Modificación datos de clientes     | 3     | NO     |
