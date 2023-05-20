Se pide una aplicación para **gestionar** el **embolsado** de los <u>productos</u> de los <u>pedidos</u> de <u>supermercado</u> online sOOPer.<br>
Actualmente hay dos <u>tipos</u> de <u>contenedores</u>: <u>bolsas</u> y <u>cajas</u>. Las cajas son *rectangulares* y aguantan "cualquier <u>peso</u>", mientras que las bolsas tienen una <u>resistencia</u> máxima.
En ambos casos, tenemos un <u>volumen</u> determinado por sus <u>dimensiones</u>. Hay varios <u>tamaños</u> disponibles.<br>
Los productos del supermercado se dividen en varias <u>categorías</u>: *Alimentación, Higiene, Droguería* y *Mascotas*. Los productos de *Alimentación*, a su vez, se subdividen en *Congelados, Frescos* y *No Perecederos*.<br>
Cada <u>producto</u> tendrá un <u>volumen</u> y un <u>peso</u> determinado, que tendremos que considerar "*ocupado*" cuando lo **embolsemos**.<br>
Los <u>productos</u> de *alimentación* no pueden ser **mezclados** con los de las otras <u>categorías</u>.
Los de *higiene* no se pueden mezclar con los de *alimentación*, y los de *droguería*, ni con los de *alimentación* ni con los de *mascotas*.<br>
En la primera versión de ésta aplicación no es necesario **optimizar** la <u>distribución</u> ni **tener en cuenta** <u>temperaturas</u> ni <u>caducidades</u>.


### Para desarrollar en enunciado anterior se han determinado tres conceptos y su forma de identificarlos son los siguientes:
1. verbos (acciones): **negritas.**
2. nombres: <u>subrayado.</u>
3. valores: *cursivas.*

### La lista queda de la siguiente manera:
<table>
    <th><u>Nombres</u></th><th><u>Verbos</u></th><th><u>Valores</u></th>
	<tr><td>producto</td><td>gestionar</td><td>rectangular</td></tr>
    <tr><td>pedido</td><td>embolsar</td><td>alimentación</td></tr>
    <tr><td>supermercado</td><td>mezclar</td><td>higiene</td></tr>
    <tr><td>tipo de contenedor</td><td rowspan="10"></td><td>droguería</td></tr>
    <tr><td>contenedor</td><td>mascotas</td></tr>
    <tr><td>bolsa</td><td>congelados</td></tr>
    <tr><td>caja</td><td>frescos</td></tr>
    <tr><td>peso</td><td>no perecederos</td></tr>
    <tr><td>resistencia</td><td>ocupado</td></tr>
    <tr><td>volumen</td><td rowspan="4"></td></tr>
    <tr><td>dimenciones</td></tr>
    <tr><td>tamaños</td></tr>
    <tr><td>categorías</td></tr>
</table>