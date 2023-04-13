package id.co.bca.spring.payment.controller;

import id.co.bca.spring.payment.model.TransactionModel;
import id.co.bca.spring.payment.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    @Qualifier("transactionService")
    private ITransactionService transactionService;

    @GetMapping("/inq/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionModel> findAllByCustomerId(@PathVariable("customerId") int customerId){
        return transactionService.findAllByCustomerId(customerId);
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.OK)
    public TransactionModel insertTransaction(@RequestBody TransactionModel transaction){
        return transactionService.insert(transaction);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionModel updateTransaction(@RequestBody TransactionModel transaction,@PathVariable("id")int id){
        transaction.setId(id);
        Date date = new Date();
        String strDateFormat = "dd-MM-yyyy";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate = dateFormat.format(date);
        transaction.setTran_date(formattedDate);
        Date invoice = new Date();
        String strInvoiceFormat = "ddMMyyyykkmmss";
        DateFormat invoiceFormat = new SimpleDateFormat(strInvoiceFormat);
        String formattedinvoice = invoiceFormat.format(invoice);
        transaction.setInvoiceReffNo(formattedinvoice);
        return transactionService.update(transaction);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionModel deleteTransaction(@PathVariable("id") int id){
        TransactionModel model = new TransactionModel();
        model.setId(id);
        return transactionService.delete(model);
    }

//    public String insertTransaction(@RequestParam("customerId") int customerId,
//                                    @RequestParam("packageId") int packageId,
//                                    @RequestParam("qty") int qty,
//                                    @RequestParam("totalAmount") double totalAmount,
//                                    @RequestParam("status") String status,
//                                    @RequestParam("invoiceReffNo") String invoiceReffNo
//                                    ){
//        TransactionModel model = new TransactionModel();
//        model.setId(0);
//        model.setCustomerId(customerId);
//        model.setPackageId(packageId);
//        model.setQty(qty);
//        model.setTotalAmount(totalAmount);
//        model.setStatus(status);
//        model.setInvoiceReffNo(invoiceReffNo);
//        transactionService.insert(model);
//        return "Successful Insert Transaction";
//    }

//    @GetMapping("/update")
//    public String updateTransaction(@RequestParam("Id") int Id,
//                                    @RequestParam("paymentMethod") String paymentMethod,
//                                    @RequestParam("cardNumber") String cardNumber,
//                                    @RequestParam("accountNo") String accountNo,
//                                    @RequestParam("status") String status,
//                                    @RequestParam("invoiceReffNo") String invoiceReffNo
//                                    ){
//        TransactionModel model = new TransactionModel();
//        Date date = new Date();
//        String strDateFormat = "dd-mm-ccyy";
//        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
//        String formattedDate = dateFormat.format(date);
//        model.setId(0);
//        model.setTran_date(formattedDate);
//        model.setPaymentMethod(paymentMethod);
//        model.setCardNumber(cardNumber);
//        model.setAccountNo(accountNo);
//        model.setStatus(status);
//        model.setInvoiceReffNo(invoiceReffNo);
//        transactionService.update(model);
//        return "Succesful Pay Transaction";
//    }

//    @GetMapping("/delete")
//    public String deleteEmployee(@RequestParam("id") int id){
//        TransactionModel model = new TransactionModel();
//        model.setId(id);
//        transactionService.delete(model);
//        return "Succesful Cancel Payment";
//    }

}
