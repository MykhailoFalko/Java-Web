<!DOCTYPE html>
<html lang="en">
<head>
    <title>Beauty Salon</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

        .row.content {height: 450px}

        .sidenav {
            padding-top: 20px;
            background-color: #f1f1f1;
            height: 100%;
        }

        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }

        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }
            .row.content {height:auto;}
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">Beauty Salon</a>
        </div>
        <div class="collapse navbar-collapse" >
            <ul class="nav navbar-nav">
                <li>
                <form class="navbar-form navbar-left" action="controller" method="post">
                    <input type="hidden" name="command" value="listSpec" />
                    <button type="submit" class="btn btn-default">Our specialists</button>
                 </form>
                 </li>
                <li>
                    <form class="navbar-form navbar-left" action="controller" method="post">
                        <input type="hidden" name="command" value="listProc" />
                        <button type="submit" class="btn btn-default">Our procedures</button>
                    </form>
                </li>
             </ul>
             <ul class="nav navbar-nav navbar-right">
                 <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
             </ul>
         </div>
     </div>
 </nav>

 <div class="container text-center">
     <div class="row content">
         <div>
             <h1 class="text-center">Welcome</h1>
             <p>Here at out Beauty Salon we believe that every one deserves to have their moment of glory and what does it better than a makeup made by professionals? </p>
             <p>Our specialists are ready to give that desirable sense of glory.</p>
         </div>
     </div>
 </div>

 <div class="jumbotron text-center" style="margin-bottom:0">
                 <div class="row justify-content-start">
                     <h6 class="text-uppercase fw-bold mb-4">
                         <i class="fas fa-gem me-3"></i>Beauty Salon
                     </h6>
                     <p>
                       Hours of Work
                     </p>
                     <p>
                         Mon.- Sun. 9:00-21:00
                     </p>
                 </div>
                 <div class="row justify-content-end">

                     <h6 class="text-uppercase">
                         Contact
                     </h6>
                     <p><i class="fas fa-home me-3"></i> New York, NY 10012, US</p>
                     <p>
                         <i class="fas fa-envelope me-3"></i>
                         info@example.com
                     </p>
                     <p><i class="fas fa-phone me-3"></i> + 01 234 567 88</p>
                     <p><i class="fas fa-print me-3"></i> + 01 234 567 89</p>
                 </div>
     <div class="text-center">
          2021 Copyright:
         <a class="text-reset fw-bold" href="#">BeautySalon.com</a>
     </div>
 </div>

 </body>
 </html>
