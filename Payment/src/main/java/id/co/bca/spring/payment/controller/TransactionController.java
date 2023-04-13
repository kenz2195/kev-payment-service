package id.co.bca.spring.payment.controller;

import id.co.bca.spring.payment.model.TransactionModel;
import id.co.bca.spring.payment.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    @Qualifier("transactionService")
    private ITransactionService transactionService;

    @GetMapping("/inq")
    public @ResponseBody TransactionModel getTransaction(@RequestParam("customerId") int customerId){
        TransactionModel model = new TransactionModel();
        model.setCustomerId(customerId);
        return transactionService.findTheTransaction(model);
    }

    @GetMapping("/insert")
    public String insertTransaction(@RequestParam("customerId") int customerId,
                                    @RequestParam("packageId") int packageId,
                                    @RequestParam("paymentMethod") String paymentMethod,
                                    @RequestParam("cardNumber") String cardNumber,
                                    @RequestParam("accountNo") String accountNo,
                                    @RequestParam("qty") int qty,
                                    @RequestParam("totalAmount") double totalAmount,
                                    @RequestParam("status") String status,
                                    @RequestParam("invoiceReffNo") String invoiceReffNo
                                    ){
        TransactionModel model = new TransactionModel();
        Date date = new Date();
        String strDateFormat = "dd-mm-ccyy";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate = dateFormat.format(date);
        model.setId(0);
        model.setCustomerId(customerId);
        model.setTran_date(formattedDate);
        model.setPackageId(packageId);
        model.setPaymentMethod(paymentMethod);
        model.setCardNumber(cardNumber);
        model.setAccountNo(accountNo);
        model.setQty(qty);
        model.setTotalAmount(totalAmount);
        model.setStatus(status);
        model.setInvoiceReffNo(invoiceReffNo);
        transactionService.insert(model);
        return "Successful Insert Transaction";
    }
}
