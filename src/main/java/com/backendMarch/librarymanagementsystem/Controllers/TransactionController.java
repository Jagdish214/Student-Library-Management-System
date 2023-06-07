package com.backendMarch.librarymanagementsystem.Controllers;


import com.backendMarch.librarymanagementsystem.DTOs.IssueBookRequestDto;
import com.backendMarch.librarymanagementsystem.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {


    @Autowired
    TransactionService transactionService;

    @PostMapping("issueBook")
    public String issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto){

        try{
            return transactionService.issueBook(issueBookRequestDto);
        }catch (Exception e){
            return e.getMessage();
        }

    }

    @GetMapping("/getTxnInfo")
    public String getTransactionEntry(@RequestParam("bookId")Integer bookId,@RequestParam("cardId")Integer cardId){

        return transactionService.getTransactions(bookId,cardId);
    }
}
