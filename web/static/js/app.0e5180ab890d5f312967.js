webpackJsonp([1],{"2WYL":function(e,t){},"3Uwz":function(e,t){},JHNi:function(e,t){},NHnr:function(e,t,o){"use strict";function a(e){o("JHNi")}function r(e){o("j0BY")}function n(e){o("pa/M")}function i(e){o("3Uwz")}function s(e){o("iSMf")}function c(e){o("2WYL")}Object.defineProperty(t,"__esModule",{value:!0});var d=o("/5sW"),l={name:"Inicio",props:["datosUsuario"],data:function(){return{}},methods:{},beforeMount:function(){var e=this;axios.get("/JInicio").then(function(t){e.usuario=t.data}).catch(function(e){console.log("fallo por esto: "+e)})},computed:{}},u=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",[o("h1",[e._v("Inicio")]),e._v(" "),o("div",[e._v("Bienvenido "+e._s(e.datosUsuario.encargado.nombre))])])},v=[],p={render:u,staticRenderFns:v},m=p,f=o("VU/8"),_=a,h=f(l,m,!1,_,"data-v-3f7018f1",null),g=h.exports,b=o("mvHQ"),C=o.n(b),V={name:"CarroCompra",props:["datos","datosUsuario"],data:function(){return{}},methods:{eliminar:function(e){this.datos.detalles.splice(e,1)},agregar:function(e){var t=this,o=this.datos.detalles.find(function(e){return e.id==t.datos.selected.id});void 0==o?this.datos.detalles.push({id:this.datos.selected.id,nombre:this.datos.selected.nombre,precio:this.datos.selected.precio,cantidad:1}):o.cantidad=parseInt(o.cantidad)+1},hacerPedido:function(){var e=this,t={pago:this.datos.pago,retiro:this.datos.retiro,detalle:this.datos.detalles};console.log("hacemos un POST con "+C()(t)),axios.post("/JCompras",t).then(function(t){console.log("funciono"),console.log(t.data.nombre),e.$emit("openVoucher",t.data)}).catch(function(e){console.log("fallo por esto: "+e)})}},beforeMount:function(){var e=this;axios.get("/JCarreteras").then(function(t){e.datos.carreteras=t.data,e.datos.selected=e.datos.carreteras[0]}).catch(function(e){console.log("fallo por esto: "+e)})},computed:{total:function(){return this.datos.detalles.map(function(e){return e.precio*e.cantidad}).reduce(function(e,t){return e+t},0)}}},w=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",[o("h1",[e._v("Carro de Compra")]),e._v(" "),o("div",[e._v("Rut: "+e._s(e.datosUsuario.empresa.rutEmpresa))]),e._v(" "),o("div",[e._v("Nombre: "+e._s(e.datosUsuario.empresa.nombreEmpresa))]),e._v(" "),o("div",[e._v("Dirección: "+e._s(e.datosUsuario.empresa.direccion))]),e._v(" "),o("div",[e._v("Comprado Por: "+e._s(e.datosUsuario.encargado.nombre))]),e._v(" "),o("div",[e._v("\n     Seleccione Carretera, indique la cantidad y agregue al pedido.\n     "),o("br"),e._v(" "),o("select",{directives:[{name:"model",rawName:"v-model",value:e.datos.selected,expression:"datos.selected"}],on:{change:function(t){var o=Array.prototype.filter.call(t.target.options,function(e){return e.selected}).map(function(e){return"_value"in e?e._value:e.value});e.$set(e.datos,"selected",t.target.multiple?o:o[0])}}},[o("option",{attrs:{selected:"",disabled:""}},[e._v("Seleccione una carretera")]),e._v(" "),e._l(e.datos.carreteras,function(t){return[o("option",{domProps:{value:t}},[e._v(e._s(t.nombre))])]})],2),e._v(" "),o("button",{staticClass:"boton_chico",on:{click:e.agregar}},[e._v("Agregar")])]),e._v(" "),o("div",[e._v("\n   Opciones de Pago:\n   "),o("input",{directives:[{name:"model",rawName:"v-model",value:e.datos.pago,expression:"datos.pago"}],attrs:{type:"radio",value:"transferencia"},domProps:{checked:e._q(e.datos.pago,"transferencia")},on:{change:function(t){e.$set(e.datos,"pago","transferencia")}}}),e._v("Transferencia\n   "),o("input",{directives:[{name:"model",rawName:"v-model",value:e.datos.pago,expression:"datos.pago"}],attrs:{type:"radio",value:"pagoEnLinea"},domProps:{checked:e._q(e.datos.pago,"pagoEnLinea")},on:{change:function(t){e.$set(e.datos,"pago","pagoEnLinea")}}}),e._v("Pago en Línea\n   "),o("input",{directives:[{name:"model",rawName:"v-model",value:e.datos.pago,expression:"datos.pago"}],attrs:{type:"radio",value:"ordenDeCompra"},domProps:{checked:e._q(e.datos.pago,"ordenDeCompra")},on:{change:function(t){e.$set(e.datos,"pago","ordenDeCompra")}}}),e._v("Orden de Compra\n ")]),e._v(" "),o("div",[e._v("\n   Opciones de Retiro:\n   "),o("input",{directives:[{name:"model",rawName:"v-model",value:e.datos.retiro,expression:"datos.retiro"}],attrs:{type:"radio",value:"oficina"},domProps:{checked:e._q(e.datos.retiro,"oficina")},on:{change:function(t){e.$set(e.datos,"retiro","oficina")}}}),e._v("Oficina\n   "),o("input",{directives:[{name:"model",rawName:"v-model",value:e.datos.retiro,expression:"datos.retiro"}],attrs:{type:"radio",value:"envioCliente"},domProps:{checked:e._q(e.datos.retiro,"envioCliente")},on:{change:function(t){e.$set(e.datos,"retiro","envioCliente")}}}),e._v("Envío Cliente\n ")]),e._v(" "),o("div",[o("table",{staticClass:"greenTable"},[e._m(0,!1,!1),e._v(" "),e._l(e.datos.detalles,function(t,a){return o("tr",[o("td",[e._v(e._s(t.nombre))]),e._v(" "),o("td",[o("input",{directives:[{name:"model",rawName:"v-model",value:t.cantidad,expression:"detalle.cantidad"}],attrs:{type:"number"},domProps:{value:t.cantidad},on:{input:function(o){o.target.composing||e.$set(t,"cantidad",o.target.value)}}})]),e._v(" "),o("td",[o("button",{staticClass:"boton_enano",on:{click:function(t){e.eliminar(a)}}},[e._v("-")])])])})],2)]),e._v(" "),o("h2",[o("div",[e._v("\n  Total a Pagar $ "+e._s(e.total)+"\n")])]),e._v(" "),o("button",{staticClass:"boton_chico",attrs:{disabled:0==e.total},on:{click:e.hacerPedido}},[e._v("Hacer Pedido")])])},P=[function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("tr",[o("th",[e._v("Carretera")]),e._v(" "),o("th",[e._v("Cantidad")]),e._v(" "),o("th",[e._v("Eliminar")])])}],x={render:w,staticRenderFns:P},y=x,E=o("VU/8"),U=r,S=E(V,y,!1,U,"data-v-10b363d8",null),k=S.exports,$=o("fZjL"),I=o.n($),T={name:"Historial",data:function(){return{detalles:[]}},methods:{pedir:function(e,t){this.$emit("openCarroCompra",t)}},beforeMount:function(){var e=this;axios.get("/JHistorial").then(function(t){e.detalles=t.data}).catch(function(e){console.log("fallo por esto: "+e)})},computed:{historial:function(){return function(e){var t=function(e,t){return e.reduce(function(e,o){return(e[o[t]]=e[o[t]]||[]).push(o),e},{})}(e,"idCompra");return I()(t).map(function(e){var o=t[e],a=o.map(function(e){return e.precio*e.cantidad}).reduce(function(e,t){return e+t},0),r=o.map(function(e){return e.nombre}).join("-"),n=o;return{idCompra:parseInt(e),pedido:r,total:a,detalle:n}})}(this.detalles)}}},R=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",[o("h1",[e._v("Historial")]),e._v(" "),o("div",[o("table",{staticClass:"greenTable"},[e._m(0,!1,!1),e._v(" "),e._l(e.historial,function(t){return o("tr",[o("td",[e._v(e._s(t.pedido))]),e._v(" "),o("td",[e._v(e._s(t.total))]),e._v(" "),o("td",[o("button",{staticClass:"boton_enano",on:{click:function(o){e.pedir(t.id,t.detalle)}}},[e._v("+")])])])})],2)])])},H=[function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("tr",[o("th",[e._v("Pedido")]),e._v(" "),o("th",[e._v("Total")]),e._v(" "),o("th",[e._v("Pedir")])])}],M={render:R,staticRenderFns:H},q=M,F=o("VU/8"),N=n,A=F(T,q,!1,N,"data-v-69f59a63",null),z=A.exports,J={name:"Voucher",data:function(){return{}},props:["datos"],methods:{hacerPedido:function(){var e={pago:this.pago,retiro:this.retiro,detalle:this.detalles};console.log("hacemos un POST con "+C()(e)),axios.post("carreteras",e).then(function(e){console.log(e)}).catch(function(e){console.log("fallo por esto: "+e)})}},beforeMount:function(){},computed:{total:function(){return this.datos.detalles.map(function(e){return e.precio*e.cantidad}).reduce(function(e,t){return e+t},0)}}},j=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",[o("h1",[e._v("Voucher")]),e._v(" "),o("div",[e._v("Pedido Número: "+e._s(e.datos.pedido))]),e._v(" "),o("div",[o("table",{staticClass:"greenTable"},[e._m(0,!1,!1),e._v(" "),e._l(e.datos.detalles,function(t,a){return o("tr",[o("td",[e._v(e._s(t.nombre))]),e._v(" "),o("td",[e._v("\n        "+e._s(t.cantidad)+"\n      ")])])})],2)]),e._v(" "),o("h2",[e._v("Total a Pagar $"+e._s(e.total))]),e._v(" "),o("br"),e._v("\n Opción de Envío: "+e._s(e.datos.retiro)+"\n "),o("br"),e._v("\n Muchas Gracias por preferirnos\n")])},L=[function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("tr",[o("th",[e._v("Carretera")]),e._v(" "),o("th",[e._v("Cantidad")])])}],O={render:j,staticRenderFns:L},B=O,G=o("VU/8"),Q=i,D=G(J,B,!1,Q,"data-v-e8b72004",null),W=D.exports,Y={name:"VerCarreteras",data:function(){return{usuario:{nombre:"Perez Ltda",rut:"12.345.678-K",direccion:"4 Norte 1329, Viña del Mar",encargado:"Juanito Perez"}}},methods:{eliminar:function(e){this.detalles.splice(e,1)},agregar:function(e){this.detalles.push({id:this.selected.id,nombre:this.selected.nombre,precio:this.selected.precio,cantidad:1})},hacerPedido:function(){var e={pago:this.pago,retiro:this.retiro,detalle:this.detalles};console.log("hacemos un POST con "+C()(e)),axios.post("carreteras",e).then(function(e){console.log(e)}).catch(function(e){console.log("fallo por esto: "+e)})}},beforeMount:function(){},computed:{total:function(){return this.detalles.map(function(e){return e.precio*e.cantidad}).reduce(function(e,t){return e+t},0)}}},K=function(){var e=this,t=e.$createElement;e._self._c;return e._m(0,!1,!1)},X=[function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",[o("h1",[e._v("Ver Carreteras")]),e._v(" "),o("div",[o("h2",[e._v("Ruta 68")]),e._v(" "),o("iframe",{staticStyle:{border:"0"},attrs:{width:"550",height:"300",frameborder:"0",src:"https://www.google.com/maps/embed/v1/place?key=AIzaSyCPpU9xywkETFG03xmgRvPuqSsFBbA1ViQ\n        &q=Ruta+68,Chile",allowfullscreen:""}})]),e._v(" "),o("div",[o("h2",[e._v("Autopista del Sol")]),e._v(" "),o("iframe",{staticStyle:{border:"0"},attrs:{width:"550",height:"300",frameborder:"0",src:"https://www.google.com/maps/embed/v1/place?key=AIzaSyCPpU9xywkETFG03xmgRvPuqSsFBbA1ViQ\n        &q=Ruta+del+Sol,Chile",allowfullscreen:""}})]),e._v(" "),o("div",[o("h2",[e._v("Guardia Vieja")]),e._v(" "),o("iframe",{staticStyle:{border:"0"},attrs:{width:"550",height:"300",frameborder:"0",src:"https://www.google.com/maps/embed/v1/place?key=AIzaSyCPpU9xywkETFG03xmgRvPuqSsFBbA1ViQ\n        &q=guardia+vieja,Chile",allowfullscreen:""}})]),e._v(" "),o("div",[o("h2",[e._v("Troncal Sur")]),e._v(" "),o("iframe",{staticStyle:{border:"0"},attrs:{width:"550",height:"300",frameborder:"0",src:"https://www.google.com/maps/embed/v1/place?key=AIzaSyCPpU9xywkETFG03xmgRvPuqSsFBbA1ViQ\n        &q=Troncal+Sur,Chile",allowfullscreen:""}})])])}],Z={render:K,staticRenderFns:X},ee=Z,te=o("VU/8"),oe=s,ae=te(Y,ee,!1,oe,"data-v-cb516bfc",null),re=ae.exports,ne={name:"app",components:{Inicio:g,CarroCompra:k,Historial:z,Voucher:W,VerCarreteras:re},data:function(){return{vista:"Inicio",datosVoucher:void 0,datosCarroCompra:{selected:"Seleccione una carretera",carreteras:[],detalles:[],pago:"transferencia",retiro:"oficina"},datosUsuario:{encargado:{rutEmpresa:"11111111-1",nombre:"Juan Perez",login:"jperez"},empresa:{rutEmpresa:"11111111-1",nombreEmpresa:"empresa 1",direccion:"direccion 1"}}}},methods:{cambiarVista:function(e){this.vista=e},abrirVoucher:function(e){this.datosVoucher=e,this.vista="Voucher",console.log("el dato del voucher:",e)},abrirCarroCompra:function(e){this.datosCarroCompra.detalles=e,this.vista="CarroCompra",console.log("el dato del carro de compra:",e)}},beforeMount:function(){var e=this;axios.get("/JInicio").then(function(t){e.datosUsuario=t.data,console.log("datos usuario: ",t.data)}).catch(function(e){console.log("fallo por esto: "+e)})}},ie=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{attrs:{id:"app"}},[o("img",{attrs:{src:"logo.svg"}}),e._v(" "),"Inicio"==e.vista?[o("Inicio",{attrs:{datosUsuario:e.datosUsuario}})]:"CarroCompra"==e.vista?[o("CarroCompra",{attrs:{datos:e.datosCarroCompra,datosUsuario:e.datosUsuario},on:{openVoucher:e.abrirVoucher}})]:"Historial"==e.vista?[o("Historial",{on:{openCarroCompra:e.abrirCarroCompra}})]:"Voucher"==e.vista?[o("Voucher",{attrs:{datos:e.datosVoucher}})]:"VerCarreteras"==e.vista?[o("VerCarreteras")]:[o("div",[e._v("error")])],e._v(" "),o("div",{attrs:{id:"menu"}},[o("button",{class:{"boton-menu":!0,activo:"Inicio"==e.vista},on:{click:function(t){e.cambiarVista("Inicio")}}},[e._v("Inicio")]),e._v(" "),o("button",{class:{"boton-menu":!0,activo:"CarroCompra"==e.vista},on:{click:function(t){e.cambiarVista("CarroCompra")}}},[e._v("Carro de Compras")]),e._v(" "),o("button",{class:{"boton-menu":!0,activo:"Historial"==e.vista},on:{click:function(t){e.cambiarVista("Historial")}}},[e._v("Historial")]),e._v(" "),o("button",{class:{"boton-menu":!0,activo:"VerCarreteras"==e.vista},on:{click:function(t){e.cambiarVista("VerCarreteras")}}},[e._v("Ver Carreteras")]),e._v(" "),void 0!=e.datosVoucher?o("button",{class:{"boton-menu":!0,activo:"Voucher"==e.vista},on:{click:function(t){e.cambiarVista("Voucher")}}},[e._v("Ver último Voucher")]):e._e(),e._v(" "),e._m(0,!1,!1)])],2)},se=[function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("form",{attrs:{action:"/privado/logout.jsp"}},[o("input",{staticClass:"boton-menu",attrs:{type:"submit",value:"Salir"}})])}],ce={render:ie,staticRenderFns:se},de=ce,le=o("VU/8"),ue=c,ve=le(ne,de,!1,ue,null,null),pe=ve.exports,me=o("mtWM"),fe=o.n(me),_e=o("KorX"),he=o.n(_e);fe.a.defaults.baseURL="",d.a.config.productionTip=!1,window.Vue=d.a,window.axios=fe.a,window.MockAdapter=he.a,window.app=new d.a({el:"#app",render:function(e){return e(pe)}})},iSMf:function(e,t){},j0BY:function(e,t){},"pa/M":function(e,t){}},["NHnr"]);
//# sourceMappingURL=app.0e5180ab890d5f312967.js.map