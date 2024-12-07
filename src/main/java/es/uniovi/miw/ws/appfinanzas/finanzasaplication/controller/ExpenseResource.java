package es.uniovi.miw.ws.appfinanzas.finanzasaplication.controller;

import es.uniovi.miw.ws.appfinanzas.finanzasaplication.model.Expense;
import es.uniovi.miw.ws.appfinanzas.finanzasaplication.model.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gastos")
public class ExpenseResource {
    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping
    public List<Expense> getExpenses() {
        return expenseRepository.findAll(); // Recupera todos los gastos desde la base de datos
    }

    @PostMapping
    public ResponseEntity<String> addExpense(@RequestBody Expense expense) {
        expenseRepository.save(expense); // Guarda el gasto en la base de datos
        return ResponseEntity.status(201).body("Gasto agregado correctamente");
    }

    @PatchMapping("/{idExpense}")
    public ResponseEntity<String> updateExpense(@PathVariable int idExpense,@RequestBody Expense updatedExpense){
   Optional<Expense> optionalExpenses =  expenseRepository.findById(idExpense);

   if(optionalExpenses.isPresent()){
       Expense expense = optionalExpenses.get();
       if(updatedExpense.getDescription()!=null && updatedExpense.getDescription().isEmpty()){
          expense.setDescription(updatedExpense.getDescription());
       }
       if(updatedExpense.getAmount()!=0){
           expense.setAmount(updatedExpense.getAmount());
       }
       if(updatedExpense.getExpenseType()!=null && updatedExpense.getExpenseType().isEmpty()){
           expense.setExpenseType(updatedExpense.getExpenseType());
       }
       expenseRepository.save(expense);
       return ResponseEntity.status(201).body("Gasto agregado correctamente");
      }else{
       return ResponseEntity.status(404).body("Gasto no encontrado");
       }

    }
}