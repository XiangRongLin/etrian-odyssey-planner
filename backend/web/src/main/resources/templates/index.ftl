<#-- @ftlvariable name="data" type="com.kaiserpudding.IndexData" -->
<html>
<body>
<ul>
    <#list data.items as item>
        <li>${item}</li>
    </#list>
</ul>
</body>
</html>
