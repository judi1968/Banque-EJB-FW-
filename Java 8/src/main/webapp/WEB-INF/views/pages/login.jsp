<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Corona Admin</title>
    <!-- plugins:css -->
    <%@ include file="../includes/css.jsp" %>
    <!-- End layout styles -->
    <link rel="shortcut icon" href="../../assets/images/favicon.png" />
  </head>
  <body>
    <div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="row w-100 m-0">
          <div class="content-wrapper full-page-wrapper d-flex align-items-center auth login-bg">
            <div class="card col-lg-4 mx-auto">
              <div class="card-body px-5 py-5">
                <h3 class="card-title text-left mb-3">Login</h3>
                <form method="post" action="/login">
                  <div class="form-group">
                    <label>Login *</label>
                    <input type="text" name="username" value="courant_insert_user" class="form-control p_input" required>
                  </div>

                  <div class="form-group">
                    <label>Password *</label>
                    <input type="password" name="password" value="1234" class="form-control p_input" required>
                  </div>

                  <div class="text-center">
                    <button type="submit" class="btn btn-primary btn-block enter-btn">Connecter</button>
                  </div>

                  <%
                      String message = (String) request.getAttribute("message");
                      if (message != null) {
                  %>
                      <div style="color: blue; font-weight: bold;"><%= message %></div>
                  <%
                      }
                  %>
                </form>
                

              </div>
            </div>
          </div>
          <!-- content-wrapper ends -->
        </div>
        <!-- row ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <!-- plugins:js -->
    <%@ include file="../includes/js.jsp" %>
    <!-- endinject -->
  </body>
</html>