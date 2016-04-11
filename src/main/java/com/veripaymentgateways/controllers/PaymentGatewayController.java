package com.veripaymentgateways.controllers;

import com.veripaymentgateways.dao.services.IPaymentGatewayService;
import com.veripaymentgateways.dto.PaymentGateway;
import com.veripaymentgateways.dto.PaymentGatewaysWrapper;
import com.veripaymentgateways.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author bajpai
 */
@Controller
public class PaymentGatewayController {

    @Autowired
    private IPaymentGatewayService paymentGatewayService;

    @RequestMapping(value = "/paymentGateways/count", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<PaymentGatewaysWrapper> getTotalCount() {
        PaymentGatewaysWrapper wrapper = paymentGatewayService.getAllGateways();
        return new ResponseEntity<PaymentGatewaysWrapper>(wrapper, HttpStatus.OK);
    }

    @RequestMapping(value = "/paymentGateways/add", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseMessage addPaymentGateway(@RequestBody PaymentGateway paymentGateway) {
        ResponseMessage responseMessage = paymentGatewayService.addPaymentGateway(paymentGateway);
        return responseMessage;
    }

    @RequestMapping(value = "/paymentGateways/search/{name}", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<PaymentGatewaysWrapper> searchByName(@PathVariable String name) {
        PaymentGatewaysWrapper wrapper = paymentGatewayService.getGatewaysByName(name);
        return new ResponseEntity<PaymentGatewaysWrapper>(wrapper, HttpStatus.OK);
    }

    @RequestMapping(value = "/paymentGateways/currency/{currency}", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<PaymentGatewaysWrapper> searchByCurrency(@PathVariable String currency) {
        PaymentGatewaysWrapper wrapper = paymentGatewayService.getGatewaysByCurrency(currency);
        return new ResponseEntity<PaymentGatewaysWrapper>(wrapper, HttpStatus.OK);
    }

    @RequestMapping(value = "/paymentGateways/delete/{id}", produces = "application/json", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseMessage deleteRecordById(@PathVariable int id) {
        ResponseMessage responseMessage = paymentGatewayService.deleteById(id);
        return responseMessage;
    }

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }
}
