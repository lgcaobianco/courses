const express = require("express");
const router = express.Router();

// Do work here
router.get("/", (req, res) => {
  res.render("hello", {
    title: "Dang"
  });
});

router.get("/reverse/:name", (req, res) => {
  const name = [...req.params.name].reverse().join("");
  res.send("Your name reversed is: " + name);
});

module.exports = router;
