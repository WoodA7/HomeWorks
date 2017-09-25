<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
    <style>
        .decl-list {
            width: 500px;
        }

        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }

        .flds {
            width: 100%;
        }

        .buttons {
            padding-top: 12px;
        }
    </style>
</head>
<div style="text-align: center;">
    <h2>Государственная Налоговая Служба</h2>
</div>
<body>
<div class="decl-list">
    <table>
        <tr>
            <th class="headrs">Имена заявителей</th>
            <th class="headrs">Дата архивации</th>
        </tr>
        <c:forEach var="num" items="${list}">
            <tr>
                <td>${num.company.name}</td>
                <td>${num.date}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <h2>Заполните декларацию:</h2>

    <form method="POST" action="путь к вашему сервлету">
        <table style="width:100%">
            <tr>
                <th>Имя заявителя</th>
                <th>Доход в месяц</th>
                <th>ID паспорта</th>
            </tr>
            <tr>
                <td><input class="flds" type="text" name="userName" placeholder="Введите имя..."/></td>
                <td><input class="flds" type="text" name="income" placeholder="Введите доход..."/></td>
                <td><input class="flds" type="text" name="passportId"
                           placeholder="Введите идентификационный номер паспорта..."/></td>
            </tr>
        </table>
        <div class="buttons">
            <input type="submit" value="Отправить на подпись"/>
        </div>
    </form>
</div>
</body>
</html>