package com.solvd.hospitaldb;

import com.solvd.hospitaldb.bin.InsurancePolicy;
import com.solvd.hospitaldb.bin.InsuranceProvider;
import com.solvd.hospitaldb.bin.Patient;
import com.solvd.hospitaldb.bin.Payment;
import com.solvd.hospitaldb.dao.InsurancePolicyDAO;
import com.solvd.hospitaldb.dao.PaymentDAO;
import com.solvd.hospitaldb.service.BillingService;
import com.solvd.hospitaldb.service.impl.BillingServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BillingTest {

    private BillingService billingService;
    private final Patient stirner =
            new Patient(1, 302, "Max", "Stirner", "1990-08-10", "Male", "215-386-7171");
    private final BigDecimal amount = new BigDecimal("105.00");
    private final Payment payment = new Payment(1, 10383, stirner, amount, "2024-02-01");
    private final InsuranceProvider provider =
            new InsuranceProvider(1, 7, "Sample Healthcare", "888-123-4567", "123 Debt Ave");

    @BeforeClass
    public void setUp() {
        PaymentDAO paymentDAO = new PaymentDAO() {
            @Override
            public void create(Payment payment) {
            }
            @Override
            public Optional<Payment> findByID(int id) {
                return Optional.empty();
            }
            @Override
            public void updateByID(Payment payment, int id) {
            }
            @Override
            public void deleteByID(Payment payment) {
            }
            @Override
            public List<Payment> getPaymentsForPatient(Integer patientID) {
                return new ArrayList<>();
            }
        };

        InsurancePolicyDAO insurancePolicyDAO = new InsurancePolicyDAO() {
            @Override
            public void create(InsurancePolicy policy) {
            }
            @Override
            public Optional<InsurancePolicy> findByID(int id) {
                return Optional.empty();
            }
            @Override
            public void updateByID(InsurancePolicy policy, int id) {
            }
            @Override
            public void deleteByID(InsurancePolicy policy) {
            }
        };
        billingService = new BillingServiceImpl(paymentDAO, insurancePolicyDAO);
    }

    @Test(description = "Verify payment processing with valid inputs")
    public void verifyProcessPaymentWithValidInputTest() {
        billingService.processPayment(payment);
        List<Payment> payments = billingService.getPaymentsForPatient(1);
        Assert.assertEquals(payments.size(), 1);
    }

    @Test(description = "Verify payment processing with invalid inputs")
    public void verifyProcessPaymentWithInvalidInputTest() {
        Payment payment1 = new Payment(2, -1, null, BigDecimal.TEN, "2024-02-01");
        List<Payment> initialPayments = billingService.getPaymentsForPatient(1);
        billingService.processPayment(payment1);
        List<Payment> finalPayments = billingService.getPaymentsForPatient(1);
        Assert.assertEquals(initialPayments, finalPayments);
    }

    @Test(description = "Verify payment refunding with valid inputs")
    public void verifyRefundPaymentWithValidInputTest() {
        billingService.refundPayment(1);
        List<Payment> payments = billingService.getPaymentsForPatient(1);
        Assert.assertEquals(payments.size(), 0);
    }

//    @Test(description = "Verify insurance registration with valid inputs")
//    public void verifyRegisterInsuranceWithValidInputTest() {
//        InsurancePolicy policy =
//                new InsurancePolicy(1, 531256, "Gold policy", stirner, provider, "High premium, low deductible");
//        billingService.registerInsurance(policy);
//    }
}