/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package one.business;

import java.math.BigDecimal;

/**
 *
 * @author Khalil
 */
public class Fees {
    
    private BigDecimal tuition;
    private BigDecimal tuitionPaid;
    
    public Fees(){
        super();
        this.tuition =  new BigDecimal(0);
        this.tuitionPaid = new BigDecimal(0);
    }

    public BigDecimal getTuition() {
        return tuition;
    }

    public BigDecimal getTuitionPaid() {
        return tuitionPaid;
    }

    public void setTuition(String tuition) {
        this.tuition = new BigDecimal(tuition);
    }

    public void setTuitionPaid(String tuitionPaid) {
        this.tuitionPaid = new BigDecimal(tuitionPaid);
    }
    
    
    
}
