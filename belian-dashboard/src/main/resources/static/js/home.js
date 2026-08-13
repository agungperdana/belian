const profileToggle = document.querySelector("[data-profile-toggle]");
const profileMenu = document.querySelector("[data-profile-menu]");
const passwordDialog = document.querySelector("#password-dialog");
const passwordForm = document.querySelector("[data-password-form]");
const toast = document.querySelector("[data-toast]");
const toastMessage = document.querySelector("[data-toast-message]");
const moduleTree = document.querySelector(".module-tree");
const moduleSearch = document.querySelector(".explorer-search input");
let toastTimer;
let searchActive = false;

function closeProfileMenu() {
    profileMenu.hidden = true;
    profileToggle.setAttribute("aria-expanded", "false");
}

function showToast(message) {
    window.clearTimeout(toastTimer);
    toastMessage.textContent = message;
    toast.hidden = false;
    toastTimer = window.setTimeout(() => {
        toast.hidden = true;
    }, 2800);
}

profileToggle.addEventListener("click", (event) => {
    event.stopPropagation();
    const willOpen = profileMenu.hidden;
    profileMenu.hidden = !willOpen;
    profileToggle.setAttribute("aria-expanded", String(willOpen));
});

profileMenu.addEventListener("click", (event) => {
    event.stopPropagation();
});

document.addEventListener("click", closeProfileMenu);
document.addEventListener("keydown", (event) => {
    if (event.key === "Escape") {
        closeProfileMenu();
        if (passwordDialog.open) {
            passwordDialog.close();
        }
    }
});

document.querySelectorAll("[data-tree-toggle]").forEach((toggle) => {
    toggle.addEventListener("click", () => {
        const children = toggle.nextElementSibling;
        const expanded = toggle.getAttribute("aria-expanded") === "true";
        toggle.setAttribute("aria-expanded", String(!expanded));
        children.hidden = expanded;
    });
});

moduleSearch.addEventListener("input", () => {
    const query = moduleSearch.value.trim().toLowerCase();
    const branches = moduleTree.querySelectorAll(".tree-branch");
    const directRows = moduleTree.querySelectorAll(":scope > .tree-row");

    if (query && !searchActive) {
        branches.forEach((branch) => {
            const parent = branch.querySelector(":scope > .tree-parent");
            parent.dataset.beforeSearchExpanded = parent.getAttribute("aria-expanded");
        });
        searchActive = true;
    }

    directRows.forEach((row) => {
        row.hidden = Boolean(query) && !row.textContent.toLowerCase().includes(query);
    });

    branches.forEach((branch) => {
        const parent = branch.querySelector(":scope > .tree-parent");
        const children = branch.querySelector(":scope > .tree-children");
        const childRows = children.querySelectorAll(":scope > .tree-row");
        const parentMatches = parent.textContent.toLowerCase().includes(query);
        const matchingChildren = [...childRows].filter((row) =>
            row.textContent.toLowerCase().includes(query)
        );

        branch.hidden = Boolean(query) && !parentMatches && matchingChildren.length === 0;
        childRows.forEach((row) => {
            row.hidden = Boolean(query) && !parentMatches
                && !row.textContent.toLowerCase().includes(query);
        });

        if (query && !branch.hidden) {
            children.hidden = false;
            parent.setAttribute("aria-expanded", "true");
        }
    });

    if (!query && searchActive) {
        branches.forEach((branch) => {
            const parent = branch.querySelector(":scope > .tree-parent");
            const children = branch.querySelector(":scope > .tree-children");
            const expanded = parent.dataset.beforeSearchExpanded === "true";
            branch.hidden = false;
            children.querySelectorAll(":scope > .tree-row").forEach((row) => {
                row.hidden = false;
            });
            parent.setAttribute("aria-expanded", String(expanded));
            children.hidden = !expanded;
            delete parent.dataset.beforeSearchExpanded;
        });
        searchActive = false;
    }
});

document.querySelectorAll("[data-message]").forEach((control) => {
    control.addEventListener("click", () => {
        showToast(control.dataset.message);
        closeProfileMenu();
    });
});

document.querySelector("[data-open-password]").addEventListener("click", () => {
    closeProfileMenu();
    passwordDialog.showModal();
    passwordDialog.querySelector("input").focus();
});

document.querySelector("[data-close-password]").addEventListener("click", () => {
    passwordDialog.close();
    passwordForm.reset();
});

passwordDialog.addEventListener("click", (event) => {
    if (event.target === passwordDialog) {
        passwordDialog.close();
        passwordForm.reset();
    }
});

passwordForm.addEventListener("submit", (event) => {
    event.preventDefault();
    const newPassword = document.querySelector("#new-password");
    const confirmPassword = document.querySelector("#confirm-password");

    confirmPassword.setCustomValidity(
        newPassword.value === confirmPassword.value ? "" : "Passwords do not match"
    );
    if (!passwordForm.reportValidity()) {
        return;
    }

    passwordDialog.close();
    passwordForm.reset();
    showToast("Sample password updated");
});

document.querySelector("[data-sample-form]").addEventListener("submit", (event) => {
    event.preventDefault();
    if (!event.currentTarget.reportValidity()) {
        return;
    }
    showToast("Purchase request submitted for approval");
});
