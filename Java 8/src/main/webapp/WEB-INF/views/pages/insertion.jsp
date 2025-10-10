<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.entity.Personnes" %>
<%
  List<Personnes> personnes = (List<Personnes>) request.getAttribute("personnes");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Form</title>
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
              <h1 class="page-title"> Insertion des mouvements </h1>

            </div>
            <div class="row">
              <div class="col-lg-4 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">Mouvement courant</h4>
                    <form class="forms-sample" action="/courant" method="post">
                      <div class="row">
                        <div class="col-md-12">
                          <div class="form-group row">
                            <label for="exampleInputUsername2" class="col-sm-3 col-form-label">Personne</label>
                            <div class="col-sm-9">
                              <select id="exampleInputUsername2" name="personneId" class="form-control">
                                <option value="">-- Sélectionnez une personne --</option>
                                <%
                                    if (personnes != null && !personnes.isEmpty()) {
                                        for (Personnes p : personnes) {
                                %>
                                    <option value="<%= p.getId() %>"><%= p.getNom() %></option>
                                <%
                                        }
                                    } else {
                                %>
                                    <option disabled>Aucune personne disponible</option>
                                <%
                                    }
                                %>
                              </select>
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="exampleInputEmail2" class="col-sm-3 col-form-label">Type action</label>
                            <div class="col-sm-9">
                              <select id="exampleInputUsername2" name="action" class="form-control">
                                <option value="">-- Sélectionnez un action --</option>
                                <option value="1">Mettre un argent</option>
                                <option value="2">Faire un retrait</option>
                              </select>
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="exampleInputMobile" class="col-sm-3 col-form-label">Montant</label>
                            <div class="col-sm-9">
                              <input type="text" class="form-control" name="montant" id="exampleInputMobile" placeholder="Mobile number">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="dateHeureAction" class="col-sm-3 col-form-label">Date et Heure</label>
                            <div class="col-sm-9">
                                <input type="datetime-local" class="form-control" name="dateHeureAction" id="dateHeureAction">
                            </div>
                        </div>
                        </div>  
                      </div>
                      <button type="submit" class="btn btn-primary me-2">Valider</button>
                      <div style="margin-top:10px;">
                        <%
                            String reussi = (String) session.getAttribute("courantReussi");
                            if (reussi != null) {
                        %>
                            <div class="alert alert-success" role="alert">
                                <%= reussi %>
                            </div>
                        <%
                                session.removeAttribute("courantReussi"); // Afficher qu'une fois
                            }
                        %>

                        <%-- Message erreur --%>
                        <%
                            String erreur = (String) session.getAttribute("courantErreur");
                            if (erreur != null) {
                        %>
                            <div class="alert alert-danger" role="alert">
                                <%= erreur %>
                            </div>
                        <%
                                session.removeAttribute("courantErreur"); // Afficher qu'une fois
                            }
                        %>
                    </div>
                    </form>
                  </div>
                </div>
              </div>
              <div class="col-lg-4 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">Mouvement courant</h4>
                    <form class="forms-sample" href="/courant" method="post">
                      <div class="row">
                        <div class="col-md-12">
                          <div class="form-group row">
                            <label for="exampleInputUsername2" class="col-sm-3 col-form-label">Personne</label>
                            <div class="col-sm-9">
                              <select id="exampleInputUsername2" name="personneId" class="form-control">
                                <option value="">-- Sélectionnez une personne --</option>
                                <%
                                    if (personnes != null && !personnes.isEmpty()) {
                                        for (Personnes p : personnes) {
                                %>
                                    <option value="<%= p.getId() %>"><%= p.getNom() %></option>
                                <%
                                        }
                                    } else {
                                %>
                                    <option disabled>Aucune personne disponible</option>
                                <%
                                    }
                                %>
                              </select>
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="exampleInputEmail2" class="col-sm-3 col-form-label">Type action</label>
                            <div class="col-sm-9">
                              <select id="exampleInputUsername2" name="personneId" class="form-control">
                                <option value="">-- Sélectionnez un action --</option>
                                <option value="1">Faire un retrait</option>
                                <option value="2">Mettre un argent</option>
                              </select>
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="exampleInputMobile" class="col-sm-3 col-form-label">Montant</label>
                            <div class="col-sm-9">
                              <input type="text" class="form-control" id="exampleInputMobile" placeholder="Mobile number">
                            </div>
                          </div>
                          
                        </div>  
                      </div>
                      <button type="submit" class="btn btn-primary me-2">Inserer</button>
                    </form>
                  </div>
                </div>
              </div>
              <div class="col-lg-4 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">Mouvement courant</h4>
                    <form class="forms-sample" action="/courant" method="post">
                      <div class="row">
                        <div class="col-md-12">
                          <div class="form-group row">
                            <label for="exampleInputUsername2" class="col-sm-3 col-form-label">Personne</label>
                            <div class="col-sm-9">
                              <select id="exampleInputUsername2" name="personneId" class="form-control">
                                <option value="">-- Sélectionnez une personne --</option>
                                <%
                                    if (personnes != null && !personnes.isEmpty()) {
                                        for (Personnes p : personnes) {
                                %>
                                    <option value="<%= p.getId() %>"><%= p.getNom() %></option>
                                <%
                                        }
                                    } else {
                                %>
                                    <option disabled>Aucune personne disponible</option>
                                <%
                                    }
                                %>
                              </select>
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="exampleInputEmail2" class="col-sm-3 col-form-label">Type action</label>
                            <div class="col-sm-9">
                              <select id="exampleInputUsername2" name="action" class="form-control">
                                <option value="">-- Sélectionnez un action --</option>
                                <option value="1">Faire un retrait</option>
                                <option value="2">Mettre un argent</option>
                              </select>
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="exampleInputMobile" class="col-sm-3 col-form-label">Montant</label>
                            <div class="col-sm-9">
                              <input type="text" class="form-control" name="montant" id="exampleInputMobile" placeholder="Mobile number">
                            </div>
                          </div>
                          
                        </div>  
                      </div>
                      <button type="submit" class="btn btn-primary me-2">Inserer</button>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- content-wrapper ends -->
          <!-- partial:../../partials/_footer.html -->
          
          <%@ include file="../includes/footer.jsp" %>
          <!-- partial -->
        </div>
        <!-- main-panel ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <%@ include file="../includes/js.jsp" %>
  </body>
</html>