<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Malte Dammann">

    <title>Index Page - KmSe</title>

    <!-- Bootstrap core CSS -->
    <link href="../../css/css/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="../../css/css/modern-business.css" rel="stylesheet">
    <link href="../../css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <!-- You'll want to use a responsive image option so this logo looks good on devices - I recommend using something like retina.js (do a quick Google search for it and you'll find it) -->
          <a class="navbar-brand" href="../../index.jsp">KmS</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="../Login/index.jsp">Login</a></li>
            <li><a href="../Register/index.jsp">Sign Up</a></li>          
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Other Pages <b class="caret"></b></a>
              <ul class="dropdown-menu">
            	<li role="presentation" class="dropdown-header">For your Interest</li>
                <li role="presentation" class="divider"></li>
                <li><a href="../AboutUs/index.jsp">About Us</a></li>
                <li><a href="../Contact/index.jsp">Kontakt</a></li>
                <li><a href="../Service/index.jsp">Info</a></li>
                <li><a href="../FAQ/index.jsp">FAQ</a></li>
                <li><a href="../Sidebar/index.jsp">Sidebar Page</a></li>
              </ul>
            </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
    </nav>

    <!-- Page Content -->

    <div class="container">
      
      <div class="row">
        <div class="col-md-3 col-sm-4 sidebar">
            <ul class="nav nav-stacked nav-pills">
              <li><a href="../../index.jsp">Home</a></li>
              <li><a href="../AboutUs/index.jsp">About</a></li>
              <li><a href="../Service/index.jsp">Services</a></li>
              <li><a href="../Contact/index.jsp">Contact</a></li>
              <li class="active"><a href="index.jsp">Sidebar Page</a></li>
              <li><a href="../FAQ/index.jsp">FAQ</a></li>
            </ul>
        </div>
      
        <div class="col-md-9 col-sm-8">
          <h1 class="page-header">Index Page <small>Behalte den &Uuml;berblick.</small></h1>
          <ol class="breadcrumb">
            <li><a href="../../index.jsp">Home</a></li>
            <li class="disabled"><a href="#">Other Pages</a></li>
            <li class="active">Index Page</li>
          </ol>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam placerat nunc ut tellus tristique, non posuere neque iaculis. Fusce aliquet dui ut felis rhoncus, vitae molestie mauris auctor. Donec pellentesque feugiat leo a adipiscing. Pellentesque quis tristique eros, sed rutrum mauris.</p>
        </div>

      </div><!-- /.row -->

    </div><!-- /.container -->

    <div class="container">

      <hr>

      <footer>
        <div class="row">
          <div class="col-lg-12">
            <p>Copyright &copy; KmS 2013</p>
          </div>
        </div>
      </footer>

    </div><!-- /.container -->

    <!-- Bootstrap core JavaScript -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../../js/jquery.js"></script>
    <script src="../../js/bootstrap.js"></script>
    <script src="../../js/modern-business.js"></script>
  </body>
</html>