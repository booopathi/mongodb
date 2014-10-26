<!doctype html>
<html>
	<header>
		<title> Quize </title>
	</header>
	<section>
		<form action="/result">
			<p>Select Options</p>
			<#list opts as opt>
				<input type="radio" name="opts" value="${opt}">${opt}</input>
				</br>
			</#list>
			<input type="submit">
		</form>
	</section>
</html>
	