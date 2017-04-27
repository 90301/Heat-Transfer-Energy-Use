package com.firehairstyles.HeatTransferEnergyUse;

import com.vaadin.server.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

import materials.Material;

public class MaterialEditorUI extends FormLayout {

	TextField materialName = new TextField("Material Name");
	TextField materialRValue = new TextField("RValue");
	TextField materialSqFt = new TextField("Square Foot");

	Button createMaterial = new Button("Create Material", e -> createMaterial());

	{
		this.addComponent(materialName);
		this.addComponent(materialRValue);
		this.addComponent(materialSqFt);

		this.addComponent(createMaterial);
	}

	public MaterialEditorUI() {

	}

	private void createMaterial() {
		Double rValue = 1.0 ,SqFt = 1.0;
		Boolean error = false;
		// data validation
		if (materialName.getValue() != materialName.getEmptyValue()) {
			
		}else{
			error = true;
		}
		if (materialRValue.getValue() != materialRValue.getEmptyValue()) {
			
			try {
			rValue = Double.parseDouble(materialRValue.getValue());
			} catch (Exception e) {
				error = true;
				materialRValue.setComponentError(new UserError("Invalid number format. Rvalue should be a decimal number"));
			}
			
		} else {
			error = true;
		}
		if (materialSqFt.getValue() != materialSqFt.getEmptyValue()) {
			try {
				SqFt = Double.parseDouble(materialSqFt.getValue());
				} catch (Exception e) {
					error = true;
					materialSqFt.setComponentError(new UserError("Invalid number format. materialSqFt should be a decimal number"));
				}
		} else {
			error = true;
		}
		if (error==true) {
			return;
		}
		
		Material m = new Material();
		m.setrValue(rValue);
		m.setSqFt(SqFt);
		
		materialRValue.setComponentError(null);
		materialSqFt.setComponentError(null);
	}

}
