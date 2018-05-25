<%-- 
    
--%>
<%@page import="Servlets.CautareProducator"%>
<%@page import="Servlets.ProduseServlet"%>
<%@page import="Proiect.Produs"%>
<%@page import="crud.CrudProdus"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!--<f:view>-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <style>
            body{
                background: #eedddd;
            }
            table{
                width: 1300px;
                margin: auto;
                text-align: center;
                table-layout: fixed;
            }

            th {
                padding: 10px;
                color: white;
                border: 1px solid #080808;
                border-collapse: collapse;
                font-size: 15px;
                font-family: Georgia;
                font-style: bold;
                background: linear-gradient(top, #737373 0%, #4d4d4d 100%);
                background: -webkit-linear-gradient(top, #737373 0%, #4d4d4d 100%);
            }
            table, tr, td{
                padding: 10px;
                color: white;
                border: 1px solid #080808;
                border-collapse: collapse;
                font-size: 18px;
                font-family: Georgia;
                background: linear-gradient(top, #b3b3b3 0%, #666666 100%);
                background: -webkit-linear-gradient(top, #b3b3b3 0%, #666666 100%);
            }
            td:hover{
                background: #cccccc;
            }
        </style>
    </head>
    <body>
        <%
            CrudProdus crudProd = new CrudProdus();
            ArrayList<Produs> produse = new ArrayList<>();
            Integer suma = 0;
    
        %>


        <table id="t01">
            <thead>
                <tr>
                    <th>Cod Produs</th>
                    <th>Pret</th>
                    <th>An fabricatie</th>
                    <th>Garantie</th>
                    <th>Stoc</th>
                    <th>Marca</th>
                    <th>Producator</th>
                    <th>Tara provenienta</th>
                </tr>
            </thead>
            <%  switch (ProduseServlet.getSelectCategorie()) {
                    case ("procesor"): {
                        produse = crudProd.readProcesoare();
                        break;
                    }
                    case ("placa video"): {
                        produse = crudProd.readPlaciVideo();
                        break;
                    }
                    case ("placa de baza"): {
                        produse = crudProd.readPlaciDeBaza();
                        break;
                    }
                    case ("hard disk"): {
                        produse = crudProd.readHardDisk();
                        break;
                    }
                    case ("sursa"): {
                        produse = crudProd.readSurse();
                        break;
                    }
                    case ("placa de sunet"): {
                        produse = crudProd.readPlaciDeSunet();
                        break;
                    }
                    case ("ram"): {
                        produse = crudProd.readRAM();
                        break;
                    }
                    case ("carcasa"): {
                        produse = crudProd.readCarcase();
                        break;
                    }
                    case ("cautare"): {
                        produse = crudProd.cautareProducator(CautareProducator.getProducator());
                        break;
                    }

                }

                for (Produs p : produse) {
                suma += p.getPret() * p.getStoc();%>
            <tbody>
                <tr>
                    <td> <%= p.getCodProdus()%> </td>
                    <td> <%= p.getPret()%> </td>
                    <td> <%= p.getAnFabricatie()%> </td>
                    <td> <%= p.getGarantie()%> </td>
                    <td> <%= p.getStoc()%> </td>
                    <td> <%= p.getMarca()%> </td>
                    <td> <%= p.getProducator()%> </td>
                    <td> <%= p.getTaraProvenienta()%> </td>
                    <td>
                        <form action ="StergeProdus" method="post">
                            <input type ="hidden" name="cod" value=<%=p.getCodProdus()%> />
                            <button type="submit">Sterge</button>
                        </form>
                    </td>
                    <td>
                        <form action ="VanzareProdus" method="post">
                            <input type ="hidden" name="cod" value=<%=p.getCodProdus()%> />
                            <input type ="hidden" name="producator" value=<%=p.getProducator()%> />
                            <button type="submit">Vinde (-1) </button>
                        </form>
                    </td>
                    <td>
                        <form action ="ActualizareStoc" method="post">
                            <input type ="hidden" name="cod" value=<%=p.getCodProdus()%> />
                            <button type="submit">Actualizeaza Stoc (+1)</button>
                        </form>
                    </td>
                </tr>
            </tbody>
            <% }%>
        </table>
        <div> Suma totala:  <%= suma%> </div>
    </body>
</html>
