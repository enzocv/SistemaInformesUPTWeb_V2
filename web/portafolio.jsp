<%-- 
    Document   : portafolio
    Created on : 05-dic-2016, 16:44:28
    Author     : enzocv
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>

<%@include file="header.jsp" %>

<%@ page import = "java.util.Map" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    String codDocente = String.valueOf(session.getAttribute("codDocente"));
    String nivelUsuario = String.valueOf(session.getAttribute("nivelUsuario"));  
    String id_Curso     = request.getParameter("id_Curso");
    
    String datosCabecera[] = (String[]) request.getAttribute("campo");
    

%>

<head>
    <title>Informe Portafolio</title>
</head>
<body class="background-gray">
        <div class="container body-padding">
            <div class="row">
                <div class="form-reporte shadow">
                    <form class="form" id="form" method="post" action="GuardarPortafolio">
                        <fieldset>
                            <div class="form-group">
                                <div class="sub-title">  
                                    <h2>Informe Final de Portafolio</h2>
                                    <br>
                                    <% 
                                        String nombreUnidad = "";
                                        if(datosCabecera != null) {
                                        switch(datosCabecera[6]){
                                        case "0":
                                            nombreUnidad = "Unidad I";
                                            break;
                                        case "1":
                                            nombreUnidad = "Unidad II";
                                            break;
                                        case "2":
                                            nombreUnidad = "Unidad III";
                                            break;
                                        }
                                    %>
                                        <h4><%=nombreUnidad%></h4>
                                        <br>
                                    <% } %>
                                    <h4>Datos :</h4>
                                    <br>
                                </div>
                                <% if(datosCabecera != null) {%>
                                    <input type="hidden" name="idUnidad" class="form-control input-sm" id="" value='<%=Integer.parseInt(datosCabecera[6])+1%>'>
                                    <%} %>
                                <div class="row">                                
                                    <label class="col-lg-2 ">Codigo :</label>
                                    <div class="col-lg-4">
                                        <% if(datosCabecera != null) {%>
                                        <input type="text" name="idCurso" class="form-control input-sm" id="" value='<%=datosCabecera[0]%>' disabled>
                                        <% } else { %>
                                        <input type="text" name="idCurso" class="form-control input-sm" id="" value='' disabled>
                                        <% } %>
                                    </div>                      
                                </div>
                                
                                <div class="row">                                
                                    <label class="col-lg-2 ">Nombre :</label>
                                    <div class="col-lg-4">
                                         <% if(datosCabecera != null) {%>
                                        <input type="text" class="form-control input-sm" id="" value='<%=datosCabecera[1]%>' disabled>
                                        <% } else { %>
                                        <input type="text" class="form-control input-sm" id="" value='' disabled>
                                        <% } %>
                                    </div>                      
                                </div>
                                
                                <div class="row">                                
                                    <label class="col-lg-2 ">Docente :</label>
                                    <div class="col-lg-4">
                                         <% if(datosCabecera != null) {%>
                                        <input type="text" name="nombre" class="form-control input-sm" id="" value='<%=datosCabecera[2]%>' disabled>
                                        <% } else { %>
                                        <input type="text" class="form-control input-sm" id="" value='' disabled >
                                        <% } %>
                                    </div>                      
                                </div>
                            </div>

                            <div class="form-group">   
                                <div class="row">
                                    <div class="col-lg-5">
                                        <h4>Resumen del curso por la Unidad</h4>
                                        <br>
                                        <h4>Estudiantes</h4>
                                        <br>
                                    </div>
                                    <div class="col-lg-1 text-center">
                                        <br><br><br>
                                        <h4>Cantidad</h4>
                                    </div>
                                    <div class="col-lg-1 text-center">
                                        <br><br><br>
                                        <h4>Porcentaje</h4>
                                    </div>
                                </div>                            
                                <div class="row">                                
                                    <label class="col-lg-5 ">Matriculados</label>
                                    <div class="col-lg-1">
                                        <% if(datosCabecera != null) {%>
                                        <input type="text" name="estMatricu" class="form-control input-sm" id="" value='<%=datosCabecera[3]%>' disabled>
                                        <% } else { %>
                                        <input type="text" name="estMatricu" class="form-control input-sm" id="" value='' disabled>
                                        <% } %>
                                    </div>  
                                    <div class="col-lg-1">
                                        <input type="text" name="porcentajeMatriculados" class="form-control input-sm" id="" value='' disabled>
                                    </div>  
                                </div>
                                <div class="row">                                
                                    <label class="col-lg-5 ">Retirados</label>
                                    <div class="col-lg-1">
                                        <% if(datosCabecera != null) {%>
                                        <input type="text" name="estReti" class="form-control input-sm" id="" value='<%=datosCabecera[4]%>' disabled>
                                        <% } else { %>
                                        <input type="text" name="estReti" class="form-control input-sm" id="" value='' disabled>
                                        <% } %>
                                   </div>  
                                    <div class="col-lg-1">
                                        <input type="text" name="porcentajeRetirados" class="form-control input-sm" id="" value='' disabled>
                                   </div>  
                                </div>
                                <div class="row">                                
                                    <label class="col-lg-5 ">Abandono</label>
                                    <div class="col-lg-1">
                                        <% if(datosCabecera != null) {%>
                                        <input type="text" name="estAbando" class="form-control input-sm" id="" value='<%=datosCabecera[5]%>' disabled>
                                        <% } else { %>
                                        <input type="text" name="estAbando" class="form-control input-sm" id="" value='' disabled>
                                        <% } %>
                                    </div>  
                                    <div class="col-lg-1">
                                        <input type="text" name="porcentajeAbandono" class="form-control input-sm" id="" value='' disabled>
                                    </div>  
                                </div>
                                <div class="row">                                
                                    <label class="col-lg-5 ">Asisten</label>
                                    <div class="col-lg-1">
                                        <input type="text" name="estAsiste" class="form-control input-sm" id="" value='' disabled />
                                    </div>  
                                    <div class="col-lg-1">
                                        <input type="text" name="porcentajeAsisten" class="form-control input-sm" id="" value='' disabled>
                                    </div>  
                                    <input type="hidden" name="asiste" id="asiste" value=''>
                                </div>
                                <div class="row">                                
                                    <label class="col-lg-5 ">Aprobados</label>
                                    <div class="col-lg-1">
                                        <input type="text" name="estAprobado" class="form-control input-sm" id="" value=''>
                                    </div>  
                                    <div class="col-lg-1">
                                        <input type="text" name="porcentajeAprobados" class="form-control input-sm" id="" value='' disabled>
                                    </div>  
                                </div>
                                <div class="row">                                
                                    <label class="col-lg-5 ">Desaprobados</label>
                                    <div class="col-lg-1">
                                        <input type="text" name="estDesapro" class="form-control input-sm" id="" value=''>
                                    </div>  
                                    <div class="col-lg-1">
                                        <input type="text" name="porcentajeDesaprobados" class="form-control input-sm" id="" value='' disabled>
                                    </div>  
                                </div>                 
                            </div>    

                            <div class="form-group">
                                <label><a id="calc_percentages" class="btn btn-primary">Calcular Porcentajes</a></label>
                                <div><p id='permessage' ></p></div>
                            </div>    

                            <div class="form-group">
                                <div class="sub-title">  
                                    <h4>Material :</h4>
                                    <br>
                                    <p>1) Material  que el docente prepara  y entrega a los estudiantes durante la
                                        ejecución de los cursos :</p>   
                                </div>
                                <div class="form-group table-responsive">
                                    <table class="table table-striped table-responsive table-prueba-entrada" id="tab1_logic">
                                        <thead>
                                            <th class="col-md-1">#</th>
                                            <th class="col-md-6">Material Docente Entregado</th>
                                            <th class="col-md-1">Digital</th>
                                            <th class="col-md-1">Impreso</th>
                                            <th class="col-md-1">Cantidad</th>
                                        </thead>
                                        <tbody>
                                            <tr id='t1addr0'>
                                                <td><input name="" value="1" type="text" class="form-control"/></td>
                                                <td><input name="t1descripcion" value="" type="text" class="form-control"/></td>
                                                <td><input type="checkbox" name="t1chkdigital" value=""/></td>
                                                <td><input type="checkbox" name="t1chkimpreso" value=""/></td>
                                                <td><input name="t1cantidad"    value="" type="text" class="form-control"/></td>
                                            </tr>
                                            <tr id='t1addr1'></tr>
                                            
                                        </tbody>
                                    </table>
                                </div>
                                <label><a id="t1add_row" class="btn btn-success">Agregar Fila</a></label>
                                <label><a id='t1delete_row' class="btn btn-danger ">Eliminar Fila</a></label>
                                <div><p id='permessage1' ></p></div>
                            </div>  

                            <div class="form-group">
                                <div class="sub-title">
                                    <p>2) Material  generado por el estudiante durante el transcurso del semestre :</p>   
                                </div>
                                
                                <div class="form-group table-responsive">
                                    <table class="table table-striped table-responsive table-prueba-entrada" id="tab2_logic">
                                        <thead>
                                            <th class="col-md-1">#</th>
                                            <th class="col-md-6">Material Entregado</th>
                                            <th class="col-md-1">Digital</th>
                                            <th class="col-md-1">Impreso</th>
                                            <th class="col-md-1">Cantidad</th>
                                        </thead>
                                        <tbody>
                                            <tr id='t2addr0'>
                                                <td><input name=""              value="1" type="text" class="form-control"/></td>
                                                <td><input name="t2descripcion" value="" type="text" class="form-control"/></td>
                                                <td><input name="t2chkdigital"  value="" type="checkbox"/></td>
                                                <td><input name="t2chkimpreso"  value="" type="checkbox"/></td>
                                                <td><input name="t2cantidad"    value="" type="text" class="form-control"/></td>
                                            </tr>
                                            <tr id='t2addr1'></tr>
                                            
                                        </tbody>
                                    </table>
                                </div>
                                <label><a id="t2add_row" class="btn btn-success">Agregar Fila</a></label>
                                <label><a id='t2delete_row' class="btn btn-danger ">Eliminar Fila</a></label>
                                <div><p id='permessage2' ></p></div>
                                
                                <br><br>
                                <div class="form-group">
                                    <label>Revisado Por:</label>
                                    <input type="text" name="caRevisadoPor" value="" class="form-control"/>
                                </div> 
                                <br><br>
                                
                            <div class="form-group">
                                 <%if(nivelUsuario.equals("Usuario")){ %>
                                    <input class="btn btn-primary" type="submit" name="Guardar" value="Guardar">
                                    <input class="btn btn-primary" type="submit" name="Enviar" value="Enviar">
                                <%}%>
                                <% if(nivelUsuario.equals("Administrador") || nivelUsuario.equals("Supervisor")){ %>
                                    <input class="btn btn-success" type="submit" name="Aceptar" value="Aceptar">
                                    <input class="btn btn-danger" type="submit" name="Rechazar" value="Rechazar">
                                <% } %> 
                                <input class="btn btn-primary" type="submit" name="Informe" value="Hacer Informe">
                                <a href="consultaPruebaEntrada.jsp" class="btn btn-primary"> Volver</a>
                            </div>

                            <div class="form-group">
                                <p></p>
                            </div>
                                <input type="hidden" name="idcurso" value="<%=datosCabecera[0]%>"/>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>   
        <script>
            
            $("form").submit(function () {
            var this_master = $(this);

            this_master.find('input[type="checkbox"]').each( function () {
                var checkbox_this = $(this);
                
                    if( checkbox_this.is(":checked") == true ) {
                        checkbox_this.attr('value','1');
                    } else {
                        checkbox_this.prop('checked',true);
                        //DONT' ITS JUST CHECK THE CHECKBOX TO SUBMIT FORM DATA    
                        checkbox_this.attr('value','0');
                    }
                });
            });
            

            
            /*ADD AND DELETE ROW FOR TABLE 1*/
            var i=1;
            var calculadoPorcentajes = false;
            $("#t1add_row").click(function(){
                
                $('#t1addr'+i).html("<td><input value='"+ (i + 1) +"' type='text' class='form-control'/></td>"+
                               "<td><input name='t1descripcion"+i+"' type='text' class='form-control'/></td>"+
                               "<td><input name='t1chkdigital"+i+"'  value='' type='checkbox'/></td>"+
                               "<td><input name='t1chkimpreso"+i+"'  value='' type='checkbox'/></td>"+
                               "<td><input name='t1cantidad"+i+"' type='text' class='form-control'/></td>");


                $('#tab1_logic').append('<tr id="t1addr'+(i+1)+'"></tr>');
             i++; 
         });
            $("#t1delete_row").click(function(){
                if(i>1){
                $("#t1addr"+(i-1)).html('');
                i--;
                }
            });
            
            /*FIN TABLA 1*/
            
            /*ADD AND DELETE ROW FOR TABLE 2*/
            
            var j = 1;
            
            $("#t2add_row").click(function(){
                
                $('#t2addr'+j).html("<td><input value='"+ (j + 1) +"' type='text' class='form-control'/></td>"+
                               "<td><input name='t2descripcion"+j+"' type='text' class='form-control'/></td>"+
                               "<td><input name='t2chkdigital"+j+"'  value='' type='checkbox'/></td>"+
                               "<td><input name='t2chkimpreso"+j+"'  value='' type='checkbox'/></td>"+
                               "<td><input name='t2cantidad"+j+"' type='text' class='form-control'/></td>");


                $('#tab2_logic').append('<tr id="t2addr'+(j+1)+'"></tr>');
             j++; 
         });
            $("#t2delete_row").click(function(){
                if(j>1){
                $("#t2addr"+(j-1)).html('');
                j--;
                }
            });
            
            /*FIN TABLA 2*/
            
            $("#calc_percentages").click(function(){
                var filas = i;
                var permessage = "";
                
                if ($("input[name=estMatricu]").val() !== "") {
                    var matriculados = parseFloat( $("input[name=estMatricu]").val() );
                    var porcentajeTotal = 0.0;
                    if (matriculados >= 1) {
                        porcentajeTotal = ((matriculados / matriculados) *100) ; 
                        $("input[name=porcentajeMatriculados]").val(porcentajeTotal);
                    }
                    else{
                        $("input[name=porcentajeMatriculados]").val(0);
                    }
                    if ($("input[name=estReti]").val() !== "" && $("input[name=estAbando]").val() !== "" &&
                        $("input[name=estAprobado]").val() !== "" &&
                        $("input[name=estDesapro]").val() !== "") {

                        var retirados = parseFloat( $("input[name=estReti]").val() );
                        var abandono = parseFloat(  $("input[name=estAbando]").val() );
                        var aprobados = parseFloat( $("input[name=estAprobado]").val() );
                        var desaprobados = parseFloat( $("input[name=estDesapro]").val() );
                        $("input[name=estAsiste]").val(aprobados+desaprobados);
                        $("input[name=asiste]").val(aprobados+desaprobados);
                        var asisten = parseFloat( $("input[name=estAsiste]").val() );
                        
                        var eva = aprobados + desaprobados;

                        if ( (asisten <= matriculados && asisten > 0 ) ) {
                            if ( eva <= asisten && (aprobados + desaprobados) > 0 && aprobados >= 0 && desaprobados >= 0) {

                                var preti = (retirados * porcentajeTotal ) /   matriculados;
    
                                $("input[name=porcentajeRetirados]").val( preti );
                                
                                var paban = (abandono * porcentajeTotal) / matriculados;
                                console.log(paban);
                                
                                $("input[name=porcentajeAbandono]").val( paban );
                                $("input[name=porcentajeAsisten]").val((asisten * porcentajeTotal)/matriculados);

                                var asis = parseFloat(  $("input[name=porcentajeAsisten]").val() );

                                $("input[name=porcentajeAprobados]").val((aprobados * asis)/asisten);
                                $("input[name=porcentajeDesaprobados]").val((desaprobados * asis)/asisten);

                                calculadoPorcentajes = true;
                            }
                            else{
                                permessage = "Cantidad de aprobados y desaprobados no coinciden";
                            }
                        }else{
                            permessage = "Alumnos Asistentes mayores a los Matriculados";
                        }

                    }
                    else{
                        permessage = "Faltan Datos.";
                    }
                }
                else{
                    permessage = "Numero de Matriculados NULO";
                }
                $("#permessage").html('');
                $("#permessage").append(permessage);
            });
        </script>
                                    
    </body>
</html>