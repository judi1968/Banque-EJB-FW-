<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.model.ComptePersonne" %>
<%@ page import="com.project.entity.Personnes" %>
 
<%
   List<ComptePersonne> comptes = (List<ComptePersonne>) request.getAttribute("comptes");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>table</title>
    <!-- plugins:css -->
    <%@ include file="../includes/css.jsp" %>
  </head>
  <body>
    <div class="container-scroller">
     
      <!-- partial:partials/_sidebar.html -->
      
      <%@ include file="../includes/navbar.jsp" %>
      <!-- partial -->
      <div class="container-fluid page-body-wrapper">
        <!-- partial:partials/_navbar.html -->
        <%@ include file="../includes/header.jsp" %>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="page-header">
                    <!-- <h3 class="page-title">Table</h3> -->
                </div>
                <div class="row">
                    <div class="col-lg-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Resultat du compte bancaires</h4>
                                <div class="table-responsive">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                            <tr>
                                                <th>Personne</th>
                                                <th style="text-align: right;">Montant Courant</th>
                                                <th style="text-align: right;">Montant Dépot</th>
                                                <th style="text-align: right;">Montant Prêt</th>
                                                <th style="text-align: right;">Montant Total</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                               
                                                if(comptes != null) {
                                                    for(ComptePersonne compte : comptes) {
                                            %>
                                            <tr>
                                                <td><%= compte.getPersonne().getNom() %></td>
                                                <td style="text-align: right;"><%= compte.getMontantCourantAr() %></td>
                                                <td style="text-align: right;"><%= compte.getMontantDepotAr() %></td>
                                                <td style="text-align: right;"><%= compte.getMontantPretAr() %></td>
                                                <td style="text-align: right;"><%= compte.getMontantTotalAr() %></td>
                                            </tr>
                                            <%
                                                    }
                                                }
                                            %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <%@ include file="../includes/footer.jsp" %>
        </div>

        <!-- main-panel ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <%@ include file="../includes/js.jsp" %>
  </body>
</html>