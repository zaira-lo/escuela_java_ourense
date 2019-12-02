<%-- 
    Document   : index
    Created on : 21-feb-2019, 20:42:40
    Author     : IEUser
--%>
<%@include file="head.jsp" %>
<html>
    <%= head() %>
    <body>
	
        <h1>Formulario JSP de Login</h1> 
         <form name="form1" action="usuarios.do" method="GET">
            <table border="1">
               <tr>
                   <td>Email</td>
                   <td>
                        <input type="email" name="email" id="email" value=""
                               placeholder="Introduzca email" required="required"
                               pattern="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$"/>  
                   </td>
               </tr> 
                <tr>
                    <td>Contraseña</td>
                    <td>
                        <input type="password" name="password" 
                               placeholder="Introduzca contraseña" 
                               id="password" value="" required="required"/>  
                    </td>
                </tr> 
            </table>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>