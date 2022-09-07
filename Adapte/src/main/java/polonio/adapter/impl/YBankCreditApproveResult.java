/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polonio.adapter.impl;

import polonio.adapter.creditapi.banky.YBankCreditApprove;
import oscarblancarte.ipd.adapter.creditapi.banky.YBankCreditApproveResult;
import polonio.adapter.creditapi.banky.YBankCreditSender;
import polonio.adapter.creditapi.banky.YBankCreditSenderListener; 
import oscarblancarte.ipd.adapter.impl.YBankCreditApproveResult;
import polonio.ipd.adapter.impl.YBankCreditApproveResult;

/**
 *
 * @author SANTINOGG
 */
public class YBankCreditAdaptee implements IBankAdapter, YBankCreditSenderListener {

private YBankCreditApproveResult yresponse;

@Override
public BankCreditResponse sendCreditRequest(BankCreditRequest request) {
YBankCreditApprove yrequest = new YBankCreditApprove();
yrequest.setCredit((float) request.getAmount());
yrequest.setName(request.getCustomer());

YBankCreditSender sender = new YBankCreditSender();
sender.sendCreditForValidate(yrequest, this);

 do {
 try {
 Thread.sleep(10000);
System.out.println("YBank petición en espera....");
 } catch (Exception e) {
 e.printStackTrace();
 }
 } while (yresponse == null);

 BankCreditResponse response = new BankCreditResponse();
 response.setApproved(yresponse.getApproved() == "Y" ? true : false);
 return response;
 }

@Override
 public void notifyCreditResult(YBankCreditApproveResult result) {
 this.yresponse = result;
 }
 }
