const slug = require("slugs");

describe("my first test", function() {
  it("fills form and submits", function() {
    //arrange
    const mainUrl = "http://localhost:7777/";
    cy.visit(mainUrl + "add");
    // act
    const storeName = "my beautiful store";
    cy.get("#name").type(storeName);
    cy.get("#description").type("look at this gorgeous and delicious food");
    cy.get("#address").type("São José do Rio Preto");
    cy.wait(2000);
    cy.get("#address").type("{downarrow} {enter}");
    cy.wait(1000);
    cy.get("form").submit();
    cy.url().should("eq", mainUrl + "store/" + slug(storeName));
    //assert
  });
});
