package com.kratonsolution.belian.security.ui.user;

import java.util.Optional;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.A;
import org.zkoss.zul.Auxhead;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.ui.AbstractForm;
import com.kratonsolution.belian.common.ui.event.UIEvent;
import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.common.ui.util.FlowHelper;
import com.kratonsolution.belian.common.ui.util.GridHelper;
import com.kratonsolution.belian.common.ui.util.RowUtils;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.security.api.UserData;
import com.kratonsolution.belian.security.api.UserRoleData;
import com.kratonsolution.belian.security.api.application.UserService;
import com.kratonsolution.belian.security.api.application.UserUpdateCommand;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class UserEditContent extends AbstractForm
{	
	private static final long serialVersionUID = 5129427061088835751L;

	private UserService service = Springs.get(UserService.class);

	private Textbox name = Components.mandatoryTextBox(false);

	private Textbox email = Components.mandatoryTextBox(false);

	private A link = new A(Labels.getLabel("form.changepassword"));

	private Checkbox enabled = new Checkbox(Labels.getLabel("form.active"));

	private Grid roles = new Grid();

	private String userName;

	public UserEditContent(@NonNull String user)
	{
		super();
		this.userName = user;
		initToolbar();
		initForm();
		initRoles();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK, e->FlowHelper.next(UserUIEvent.toGrid()));
		toolbar.getSave().addEventListener(Events.ON_CLICK, e->{

			if(Strings.isNullOrEmpty(email.getText()))
				throw new WrongValueException(email, Labels.getLabel("warning.empty"));

			UserData opt = service.getByName(userName);
			if(opt != null)
			{
				UserUpdateCommand command = new UserUpdateCommand();
				command.setName(userName);
				command.setEmail(email.getText());
				command.setEnabled(enabled.isChecked());

				roles.getRows().getChildren().forEach(rw -> {

					String roleCode = RowUtils.string(((Row)rw), 0);
					if(roleCode != null) {

						Optional<UserRoleData> urd = opt.getRoles()
								.stream()
								.filter(p -> p.getRoleCode().equals(roleCode)).findFirst();

						if(urd.isPresent()) {
							urd.get().setEnabled(RowUtils.isChecked((Row)rw, 1));
						}
					}
				});

				command.getRoles().addAll(opt.getRoles());

				service.update(command);
			}

			FlowHelper.next(UserUIEvent.toGrid());
		});
	}

	@Override
	public void initForm()
	{
		UserData opt = service.getByName(this.userName);
		if(opt != null)
		{
			link.addEventListener(Events.ON_CLICK, e->FlowHelper.next(new UserUIEvent(this.userName, UIEvent.OTHER)));

			name.setConstraint("no empty");
			name.setText(opt.getName());
			name.setReadonly(true);

			email.setConstraint("no empty");
			email.setText(opt.getEmail());
			email.setWidth("250px");

			enabled.setChecked(opt.isEnabled());

			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"150px"));
			grid.getColumns().appendChild(new Column());
			grid.setSpan("2");

			Row row1 = new Row();
			row1.appendChild(new Label(Labels.getLabel("form.name")));
			row1.appendChild(name);

			Row row2 = new Row();
			row2.appendChild(new Label(Labels.getLabel("form.email")));
			row2.appendChild(email);

			Row row3 = new Row();
			row3.appendChild(new Label(Labels.getLabel("form.password")));
			row3.appendChild(link);

			Row row4 = new Row();
			row4.appendChild(new Label(Labels.getLabel("form.status")));
			row4.appendChild(enabled);

			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row4);
		}
	}

	protected void initRoles()
	{
		Auxhead head = GridHelper.buildHead(Labels.getLabel("form.userrole"), 2);

		Checkbox all = new Checkbox(Labels.getLabel("form.selectall"));
		all.addEventListener(Events.ON_CLICK, e->{
			
			Checkbox source = (Checkbox)e.getTarget();

			Rows rows = roles.getRows();
			for(Object object:rows.getChildren())
			{
				Row row = (Row)object;
				if(source.isChecked())
					RowUtils.checked(row,1);
				else
					RowUtils.unchecked(row, 1);
			}
		});

		Column col1 = new Column(Labels.getLabel("form.role"));
		col1.setWidth("175px");

		Column col2 = new Column();
		col2.appendChild(all);

		Columns columns = new Columns();
		columns.appendChild(col1);
		columns.appendChild(col2);

		roles.appendChild(head);
		roles.appendChild(columns);

		UserData opt = service.getByName(userName);
		if(opt != null)
		{
			final Rows rows = new Rows();
			opt.getRoles().forEach(role -> {

				Checkbox checkbox = new Checkbox();
				checkbox.setChecked(role.isEnabled());

				Row row = new Row();
				row.appendChild(new Label(role.getRoleCode()));
				row.appendChild(checkbox);

				rows.appendChild(row);
			});

			roles.appendChild(rows);
		}

		appendChild(roles);
	}
}
