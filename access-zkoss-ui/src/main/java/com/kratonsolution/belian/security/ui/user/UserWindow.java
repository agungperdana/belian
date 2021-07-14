package com.kratonsolution.belian.security.ui.user;

import org.zkoss.image.AImage;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.event.EventQueues;

import com.kratonsolution.belian.common.ui.AbstractWindow;
import com.kratonsolution.belian.common.ui.event.UIEvent;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
public class UserWindow extends AbstractWindow
{
	private static final long serialVersionUID = 2532837188647395498L;

	public UserWindow() {

		super();
		try {
			caption.setImageContent(new AImage(getClass().getResource("/images/fisheye/user.png")));
		} catch (Exception e) {}

		caption.setLabel(Labels.getLabel("user.caption"));
		EventQueues.lookup(UserUIEvent.class.getSimpleName()).subscribe(e->{

			UserUIEvent event = (UserUIEvent) e;

			clearContent();

			if(event.getType().equals(UIEvent.ADD_FORM)) {
				appendChild(new UserFormContent());
			}
			else if(event.getType().equals(UIEvent.EDIT_FORM)) {
				appendChild(new UserEditContent(event.getUsername()));
			}
			else if(event.getType().equals(UIEvent.GRID)) {
				appendChild(new UserGridContent());
			}
			else {
				appendChild(new ChangePassword(event.getUsername()));
			}
		});
	}
}
