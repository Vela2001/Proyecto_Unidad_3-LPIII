<%-- 
    Document   : RegistrarVenta
    Created on : 8/06/2022, 12:56:20 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <title>VENTAS</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <form action="Controlador" method="POST">
                    <div class="card-body">
                        <div class="form-group">
                            <label>Datos del Cliente</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-4 d-flex">
                                <input type="text" name="codigocliente" class="form-control col-sm-4" placeholder="Codigo">
                                <input type="submit" name="accion" value="Buscar" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nombrescliente" class="form-control col-sm-6">
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Datos Producto</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-4 d-flex">
                                <input type="text" name="codigoproducto" class="form-control col-sm-4" placeholder="Codigo">
                                <input type="submit" name="accion" value="Buscar" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nombrescliente" class="form-control col-sm-6">
                            </div>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-4 d-flex">
                                <input type="text" name="precio" class="form-control" placeholder="S/.0.00">
                            </div>
                            <div class="col-sm-3">
                                <input type="number" name="cant" placeholder="" class="form-control">
                            </div>
                            <div class="col-sm-3">
                                <input type="text" name="stock" placeholder="Stock" cclass="form-control">
                            </div>
                        </div>
                        <div class="form form-group">
                            <input type="submit" name="accion" value="Agregar" class="btn btn-outline-info">
                        </div>
                    </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ml-auto">
                            <label>NumeroSerie</label>
                            <input type="text" name="NroSerie" class="form-control">
                        </div>
                        <table class="table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                               <c:forEach var="em" items="${empleados}">
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>
                                </tr>
                               </c:forEach> 
                            </tbody>
                        </table> 
                    </div>
                        <div class="card-footer">
                            <div>
                                <input type="submit" name="accion" value="Generar Venta" class="btn btn-success">
                                <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                            </div>
                        </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
    </body>
</html>
