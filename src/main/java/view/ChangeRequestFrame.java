package view;

import controller.ChangeRequestController;
import model.Request;

public class ChangeRequestFrame extends AbstractRequestFrame {
    
    public ChangeRequestFrame(RequestsTable tableFrame, Request request) {
        super("Изменение заявления");
        
        ChangeRequestController controller = new ChangeRequestController(this, 
                tableFrame,
                request);
        
        btnSend.setText("Изменить");
        btnSend.addActionListener(controller);
        btnSend.setActionCommand("changeRequest");
        
        btnCancel.addActionListener(controller);
        btnCancel.setActionCommand("cancel");
        
        cbInstitute.addActionListener(controller);
        cbInstitute.setActionCommand("instituteChanged");
        
        setEnabled(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void setData(Request request, int instituteIndex, int reasonIndex) {
        setTextName(request.getName());
        setTextPhoneNumber(request.getPhoneNumber());
        setSelectedInstitute(instituteIndex);
        setTextPassportSeries(String.valueOf(request.getPassportSeries()));
        setTextPassportNumber(String.valueOf(request.getPassportNumber()));
        setTextPassportIssued(request.getPassportIssued());
        setTextPassportIssuedDate(request.getPassportDate());
        setSelectedReason(reasonIndex);
    }
    
}
