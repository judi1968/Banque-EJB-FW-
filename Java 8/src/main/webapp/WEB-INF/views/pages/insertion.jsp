<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.entity.Personnes" %>
<%@ page import="metier.entities.VMouvementCourantNonValide" %>
<%
  List<Personnes> personnes = (List<Personnes>) request.getAttribute("personnes");
  List<VMouvementCourantNonValide> vMouvementCourantNonValides = (List<VMouvementCourantNonValide>) request.getAttribute("vMouvementCourantNonValides");
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
                    <h4 class="card-title">Mouvement depot</h4>
                    <form class="forms-sample" action="/depot" method="post">
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
                            String reussiDepot = (String) session.getAttribute("depotReussi");
                            if (reussiDepot != null) {
                        %>
                            <div class="alert alert-success" role="alert">
                                <%= reussiDepot %>
                            </div>
                        <%
                                session.removeAttribute("depotReussi"); // Afficher qu'une fois
                            }
                        %>

                        <%-- Message erreur --%>
                        <%
                            String erreurDepot = (String) session.getAttribute("depotErreur");
                            if (erreurDepot != null) {
                        %>
                            <div class="alert alert-danger" role="alert">
                                <%= erreurDepot %>
                            </div>
                        <%
                                session.removeAttribute("depotErreur"); // Afficher qu'une fois
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
                    <h4 class="card-title">Mouvement pret</h4>
                    <form class="forms-sample" action="/pret" method="post">
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
                                <option value="1">Preter un argent</option>
                                <option value="2">Rembourser l'argent</option>
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
                            String reussiPret = (String) session.getAttribute("pretReussi");
                            if (reussiPret != null) {
                        %>
                            <div class="alert alert-success" role="alert">
                                <%= reussiPret %>
                            </div>
                        <%
                                session.removeAttribute("pretReussi"); // Afficher qu'une fois
                            }
                        %>

                        <%-- Message erreur --%>
                        <%
                            String erreurPret = (String) session.getAttribute("pretErreur");
                            if (erreurPret != null) {
                        %>
                            <div class="alert alert-danger" role="alert">
                                <%= erreurPret %>
                            </div>
                        <%
                                session.removeAttribute("pretErreur"); // Afficher qu'une fois
                            }
                        %>
                    </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
                    <div class="col-lg-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Liste des mouvements courants non valider</h4>
                                <div style="margin-top:10px;">
                        <%
                            String reussiValide = (String) session.getAttribute("courantValideReussi");
                            if (reussiValide != null) {
                        %>
                            <div class="alert alert-success" role="alert">
                                <%= reussiValide %>
                            </div>
                        <%
                                session.removeAttribute("courantValideReussi"); // Afficher qu'une fois
                            }
                        %>

                        <%-- Message erreur --%>
                        <%
                            String erreurValide = (String) session.getAttribute("courantValideErreur");
                            if (erreurValide != null) {
                        %>
                            <div class="alert alert-danger" role="alert">
                                <%= erreurValide %>
                            </div>
                        <%
                                session.removeAttribute("courantValideErreur"); // Afficher qu'une fois
                            }
                        %>
                    </div>
                                <div class="table-responsive">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                            <tr>
                                                <th style="text-align: center;">Personne</th>
                                                <th style="text-align: right;">Montant</th>
                                                <th style="text-align: center;">Type</th>
                                                <th> Action </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                               
                                                if(vMouvementCourantNonValides != null) {
                                                    for(VMouvementCourantNonValide vMouvementCourantNonValide : vMouvementCourantNonValides) {
                                            %>

                                            <tr>
                                                
                                                 <%
                                                      if (personnes != null && !personnes.isEmpty()) {
                                                          for (Personnes p : personnes) {
                                                            if(p.getId() == vMouvementCourantNonValide.getIdPersonne()){
                                                  %>
                                                      <td style="text-align: center;"><%= p.getNom() %></td>
                                                  <%
                                                            }
                                                } }
                                                  %>
                                                <%  
                                                  if(vMouvementCourantNonValide.getMontantSortie() == 0){ %>
                                                    <td style="text-align: right;"><%= vMouvementCourantNonValide.getMontantEntrer() %></td>
                                                  <% }else{ %>
                                                    <td style="text-align: right;"><%= vMouvementCourantNonValide.getMontantSortie() %></td>
                                                 <% }
                                                %>
                                                <%  
                                                  if(vMouvementCourantNonValide.getMontantEntrer() == 0){ %>
                                                    <td style="text-align: center;"><label class="badge badge-danger">Sortie</label></td>
                                                  <% }else{ %>
                                                    <td style="text-align: center;"><label class="badge badge-success">Entrer</label></td>
                                                 <% }
                                                %>
                                                <td><a href="/valider-mouvement?id=<%= vMouvementCourantNonValide.getIdMouvement() %>" class="btn btn-primary">Valider</a></td>
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