<html>
<head><title>Payment Gateways</title></head>
<body>
  <h1 style="text-align: center;"><span style="color: #800000;"><strong>PAYMENT&nbsp; GATEWAY&nbsp; PORTAL&nbsp;&nbsp;</strong></span></h1>
<h2 style="text-align: center;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color: #993300;">Welcome to Payment gateway portal.</span></h2>
<h3><span style="color: #ff0000;">You can perform following actions:</span></h3>
<ul>
<li>
<h3><span style="color: #993366;">See detailed records of all payment gateways.</span></h3>
</li>
<li>
<h3><span style="color: #993366;">Add a new payment gateway record</span></h3>
</li>
<li>
<h3><span style="color: #993366;">Delete an existing payment gateway record</span></h3>
</li>
<li>
<h3><span style="color: #993366;">Search payment gateways on basis of name.</span></h3>
</li>
<li>
<h3><span style="color: #993366;">Search payment gateways on basis of currency.</span></h3>
</li>
</ul>
<h3><span style="color: #008000;"><em>--<span style="color: #008000;">The web service is REST full and written in Java.</span></em></span></h3>
<h3><span style="color: #008000;"><span style="color: #008000;"><span style="color: #ff0000;">Note:</span> <span style="color: #0000ff; background-color: #ffff00;">To execute PUT, DELETE request, use some rest client e.g. postman.</span></span></span></h3>
<p>&nbsp;</p>
<h2><em>Below are the end points for the above actions:</em></h2>
<h2>1:&nbsp;&nbsp; <span style="text-decoration: underline;">See&nbsp; detailed records of all payment gateways:</span></h2>
<h3 style="text-align: left;"><span style="text-decoration: underline; color: #000000;">Method: GET</span></h3>
<h3 style="text-align: left;">Endpoint:</h3>
<h3 style="text-align: left;"><span style="color: #3366ff;"><a style="color: #3366ff;" href="http://veripaymentgateways-tryinj.rhcloud.com/paymentGateways/count">http://veripaymentgateways-tryinj.rhcloud.com/paymentGateways/count</a></span></h3>
<h3>&nbsp;</h3>
<h2>2:&nbsp;&nbsp;&nbsp; <span style="text-decoration: underline;">Add a new payment gateway record</span></h2>
<h3><span style="text-decoration: underline;">Endpoint</span>:</h3>
<h3><span style="color: #ff00ff;">http://veripaymentgateways-tryinj.rhcloud.com/paymentGateways/add</span></h3>
<h3><span style="text-decoration: underline;">Method: <span style="background-color: #ffff00;">PUT</span></span></h3>
<h3><span style="color: #ff0000;">Sample Request:</span></h3>
<table>
<tbody>
<tr>
<td width="616">
<h4><span style="color: #008000;">{</span></h4>
<h4><span style="color: #008000;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "Stripe",</span></h4>
<h4><span style="color: #008000;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "image": "http://hackerearth.0x10.info/api/img?img=http://www.commercegurus.com/wp-content/uploads/2014/09/Stripe-Logo.png",</span></h4>
<h4><span style="color: #008000;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "description": "Stripe is a suite of APIs that powers commerce for businesses of all sizes.",</span></h4>
<h4><span style="color: #008000;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "branding": true,</span></h4>
<h4><span style="color: #008000;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "rating": 4.1,</span></h4>
<h4><span style="color: #008000;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "currencies": ["USD", "AUD", "CAD", "GDP", "EUR", "INR"],</span></h4>
<h4><span style="color: #008000;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "setUpFee": true,</span></h4>
<h4><span style="color: #008000;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "setUpFeeAmount": 2.0,</span></h4>
<h4><span style="color: #008000;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "perTransactionFeePercentage": 0.2,</span></h4>
<h4><span style="color: #008000;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "how_to_url": "https://stripe.com/docs/checkout/tutorial"</span></h4>
<h4><span style="color: #008000;">}</span></h4>
<p>&nbsp;</p>
</td>
</tr>
</tbody>
</table>
<p>&nbsp;</p>
<h3><span style="color: #ff0000;">Datatypes:&nbsp;</span></h3>
<table>
<tbody>
<tr>
<td width="616">
<h4><span style="color: #008000;">name &ndash; String</span></h4>
<h4><span style="color: #008000;">Image &ndash; String</span></h4>
<h4><span style="color: #008000;">Description &ndash; String</span></h4>
<h4><span style="color: #008000;">Branding &ndash; Boolean (true/false)</span></h4>
<h4><span style="color: #008000;">&nbsp;Rating &ndash; float</span></h4>
<h4><span style="color: #008000;">Currencies &ndash; List&lt;String&gt;</span></h4>
<h4><span style="color: #008000;">setUpFee &ndash; boolean(true/false)</span></h4>
<h4><span style="color: #008000;">setUpFeeAmount &ndash; float</span></h4>
<h4><span style="color: #008000;">perTransactionFeePercentage &ndash; float</span></h4>
<h4><span style="color: #008000;">how_to_url - String</span></h4>
<h4><span style="color: #008000;">&nbsp;</span></h4>
</td>
</tr>
</tbody>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
<h2>3:&nbsp; &nbsp;&nbsp;<span style="text-decoration: underline;">Delete an existing payment gateway record</span></h2>
<h3><span style="text-decoration: underline;">Method: <span style="background-color: #ffff00;">DELETE</span></span></h3>
<h3><span style="text-decoration: underline;">Endpoint</span>:</h3>
<h3><span style="color: #ff00ff;">http://veripaymentgateways-tryinj.rhcloud.com/paymentGateways/delete/{id}</span></h3>
<h3>Example:<span style="color: #3366ff;"> <a style="color: #3366ff;" href="http://veripaymentgateways-tryinj.rhcloud.com/paymentGateways/delete/4">http://veripaymentgateways-tryinj.rhcloud.com/paymentGateways/delete/4</a></span></h3>
<p>&nbsp;</p>
<h2>4:&nbsp;&nbsp;&nbsp; <span style="text-decoration: underline;">Search a payment gateway on basis of name</span></h2>
<h3><span style="text-decoration: underline;">Method: GET</span></h3>
<h3><span style="text-decoration: underline;">Endpoint</span>:</h3>
<h3><span style="color: #ff00ff;">http://veripaymentgateways-tryinj.rhcloud.com/paymentGateways/search/{name}</span></h3>
<h3>Example:</h3>
<h3><span style="color: #3366ff;"><a style="color: #3366ff;" href="http://veripaymentgateways-tryinj.rhcloud.com/paymentGateways/search/payPal">http://veripaymentgateways-tryinj.rhcloud.com/paymentGateways/search/payPal</a></span></h3>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<h2>5:&nbsp;&nbsp; <span style="text-decoration: underline;">Search &nbsp;payment gateways on basis of currency.</span></h2>
<h3><span style="text-decoration: underline;">Method: GET</span></h3>
<h3><span style="text-decoration: underline;">Endpoint</span>:</h3>
<h3><span style="color: #ff00ff;">http://veripaymentgateways-tryinj.rhcloud.com/paymentGateways/currency/{currency}</span></h3>
<h3>Example:</h3>
<h3><span style="color: #3366ff;"><a style="color: #3366ff;" href="http://veripaymentgateways-tryinj.rhcloud.com/paymentGateways/currency/USD">http://veripaymentgateways-tryinj.rhcloud.com/paymentGateways/currency/USD</a></span></h3>
</body>
</html>