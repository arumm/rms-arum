<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="Introducing Lollipop, a sweet new take on Android.">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
        <title>RMS</title>

        <!-- Page styles -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.min.css">
        <link rel="stylesheet" href="css/styles.css">
        <style>
            #view-source {
                position: fixed;
                display: block;
                right: 0;
                bottom: 0;
                margin-right: 40px;
                margin-bottom: 40px;
                z-index: 900;
            }
        </style>
    </head>
    <body>
        <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
            <div class="android-header mdl-layout__header mdl-layout__header--waterfall">
                <div class="mdl-layout__header-row">
                    <span class="android-title mdl-layout-title">
                        RMS Study Case
                        <!-- <img class="android-logo-image" src="css/images/android-logo.png"> -->
                    </span>
                    <div class="android-header-spacer mdl-layout-spacer"></div>
                    <div class="android-navigation-container">
                        <nav class="android-navigation mdl-navigation">
                            <a class="mdl-navigation__link mdl-typography--text-uppercase" href="users/list">Users</a>
                        </nav>
                    </div>
                </div>
            </div>

            <div class="android-drawer mdl-layout__drawer">
                <span class="mdl-layout-title">
                    RMS Study Case
                </span>
                <nav class="mdl-navigation">
                    <a class="mdl-navigation__link" href="users/list">Users</a>
                </nav>
            </div>

            <div class="android-content mdl-layout__content">
                <div class="android-be-together-section mdl-typography--text-center">
                    <div class="logo-font android-slogan">Welcome to RMS </div>          
                </div> 
            </div>
        </div>
        <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    </body>
</html>
