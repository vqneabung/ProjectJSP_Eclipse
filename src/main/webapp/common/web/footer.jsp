<%-- 
    Document   : footer
    Created on : Jun 6, 2024, 8:55:38 AM
    Author     : VQN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="/common/web/add_css_js.jsp"%>  
    </head>
    <body>
        <c:choose>
            <c:when test="${sessionScope.User == null}">
                <header class="p-3 bg-dark text-white">
                    <div class="container">
                        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
                            </a>

                            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                                <li><a href="/ProjectJSP/StartServlet" class="nav-link px-2 text-secondary">Home</a></li>
                                <li><a href="/ProjectJSP/MealShopServlet" class="nav-link px-2 text-white">Shop</a></li>
                                <li><a href="/ProjectJSP/ManageUserMealServlet" class="nav-link px-2 text-white">Your meal plan</a></li>
                                <li><a href="/ProjectJSP/jsp/home/cart.jsp" class="nav-link px-2 text-white">Cart</a></li>
                                <li><a href="#" class="nav-link px-2 text-white">About</a></li>
                            </ul>

                            <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                                <input type="search" class="form-control form-control-dark" placeholder="Search..." aria-label="Search">
                            </form>

                            <div class="text-end">
                                <a class="btn btn-primary" href="/ProjectJSP/StartServlet" role="button" name="login">Login</a>
                            </div>
                        </div>
                    </div>
                </header>
            </c:when>
            <c:otherwise>
                <header class="p-3 bg-dark text-white">
                    <div class="container">
                        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
                                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
                            </a>

                            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                                <li><a href="/ProjectJSP/StartServlet" class="nav-link px-2 text-secondary">Home</a></li>
                                <li><a href="/ProjectJSP/MealShopServlet" class="nav-link px-2 text-white">Shop</a></li>
                                <li><a href="/ProjectJSP/ManageUserMealServlet" class="nav-link px-2 text-white">Your meal plan</a></li>
                                <li><a href="/ProjectJSP/jsp/home/cart.jsp" class="nav-link px-2 text-white">Cart</a></li>
                                <li><a href="#" class="nav-link px-2 text-white">About</a></li>
                            </ul>

                            <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                                <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
                            </form>

                            <div class="dropdown text-end">
                                <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                                    <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
                                </a>
                                <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1" style="">
                                    <c:if test="${sessionScope.User.roleID == 0}">
                                        <li><a class="dropdown-item" href="/ProjectJSP/jsp/admin/admin_home.jsp">Admin</a></li>
                                        </c:if>
                                    <li><a class="dropdown-item" href="#">Settings</a></li>
                                    <li><a class="dropdown-item" href="/ProjectJSP/ProfileServlet">Profile</a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="/ProjectJSP/LogoutServlet">Sign out</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </header>
            </c:otherwise>
        </c:choose>
    </body>
</html>
