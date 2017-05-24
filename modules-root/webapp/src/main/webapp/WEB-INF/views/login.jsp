<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="utils"%>
<html>
<head>
<title>Computer Database</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="resources/css/font-awesome.css" rel="stylesheet"
	media="screen">
<link href="resources/css/main.css" rel="stylesheet" media="screen">
<link href="resources/css/login.css" rel="stylesheet" media="screen">
</head>

<body>
	<header class="navbar navbar-inverse navbar-fixed-top">
		<utils:navbar />
	</header>

	<section id="main">
		<div class="container">
			<div class="form">

				<ul class="tab-group">
					<li class="tab active"><a href="#login">Login</a></li>
					<li class="tab"><a href="#signup">Register</a></li>
				</ul>

				<div class="tab-content">
					<div id="login">
						<h1>Hello !</h1>

						<form action="login" method="post">
							<c:if test="${param.error != null}">
								<div class="alert alert-danger">
									<p>Invalid username and password.</p>
								</div>
							</c:if>
							<c:if test="${param.logout != null}">
								<div class="alert alert-success">
									<p>You have been logged out successfully.</p>
								</div>
							</c:if>
							<div class="field-wrap">
								<label> Username<span class="req">*</span>
								</label> <input type="text" name="username" required autocomplete="off" />
							</div>

							<div class="field-wrap">
								<label> Password<span class="req">*</span>
								</label> <input type="password" name="password" required
									autocomplete="off" />
							</div>

							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />

							<button class="button button-block">Log In</button>

						</form>

					</div>

					<div id="signup">
						<h1>Sign Up</h1>

						<form action="register" method="post">
							<c:if test="${param.error != null}">
								<div class="alert alert-danger">
									<p>Invalid username and password.</p>
								</div>
							</c:if>
							<c:if test="${param.logout != null}">
								<div class="alert alert-success">
									<p>You have been logged out successfully.</p>
								</div>
							</c:if>
							<div class="field-wrap">
								<label> Set A Username<span class="req">*</span>
								</label> <input type="text" name="username" required autocomplete="off" />
							</div>

							<div class="field-wrap">
								<label> Set A Password<span class="req">*</span>
								</label> <input type="password" name="password" required
									autocomplete="off" />
							</div>

							<button type="submit" class="button button-block">Let's Go</button>

						</form>

					</div>

				</div>
				<!-- tab-content -->

			</div>
			<!-- /form -->


		</div>
	</section>

	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/login.js"></script>

</body>
</html>