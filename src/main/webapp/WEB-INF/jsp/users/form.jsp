<%@ include file="../template/header.jsp"%>
<div class="android-content mdl-layout__content ">
	<div align="center">
		<form action="form" method="post">
			<div class="mdl-card mdl-shadow--2dp">
				<div
					class="mdl-card__supporting-text mdl-color--primary mdl-color-text--white">
					<h4 class="mdl-card__title-text">User Form</h4>
				</div>
				<div class="mdl-card__supporting-text">
					<div class="mdl-textfield mdl-js-textfield">
						<input type="hidden" id="id" name="id"
							value="${empty users.id ? null : users.id}" /> <input
							class="mdl-textfield__input" type="text" id="username"
							name="username"
							value="${empty users.userName ? null : users.userName}" /> <label
							class="mdl-textfield__label" for="username">Username</label>
					</div>
					<div class="mdl-textfield mdl-js-textfield">
						<input class="mdl-textfield__input" type="password" id="userpass"
							name="password"
							value="${empty users.password ? null : users.password}" /> <label
							class="mdl-textfield__label" for="userpass">Password</label>
					</div>
				</div>
				<div class="mdl-card__actions mdl-card--border">
					<button
						class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
						type="submit">Save</button>
				</div>
			</div>
		</form>
	</div>
</div>
<%@ include file="../template/footer.jsp"%>