/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polonio.adapter.impl;
import polonio.adapter.creditapi.bankx.XBankCreditAPI;
import polonio.adapter.creditapi.bankx.XBankCreditRequest;
import polonio.adapter.creditapi.bankx.XBankCreditResponse;
/**
 *
 * @author SANTINOGG
 */
public class XbankCreditAdaptee implements IBankAdapter{
    @Override
    public BankCreditResponse sendCreditRequest(BankCreditRequest request) {
        XBankCreditRequest xrequest = new XBankCreditRequest();
        xrequest.setCustomerName(request.getCustomer());
        xrequest.setRequestAmount(request.getAmount());

 XBankCreditAPI api = new XBankCreditAPI();
 XBankCreditResponse xresponse = api.sendCreditRequest(xrequest);

 BankCreditResponse response = new BankCreditResponse();
response.setApproved(xresponse.isAproval());
 return response;
}
    }
    
    
