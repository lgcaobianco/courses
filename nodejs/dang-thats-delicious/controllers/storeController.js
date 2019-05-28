const mongoose = require("mongoose");

const Store = mongoose.model("Store");

exports.homePage = (req, res) => {
  res.render("index", {
    title: "Welcome!"
  });
};

exports.addStore = (req, res) => {
  res.render("editStore", {
    title: "Add Store"
  });
};

exports.createStore = async (req, res) => {
  const store = await new Store(req.body).save();
  req.flash(
    "success",
    `Successfully created ${store.name}. Care to leave a review?`
  );
  res.redirect(`/store/${store.slug}`);
};

exports.getStores = async (req, res) => {
  const stores = await Store.find();
  res.render("stores", {
    title: "Stores",
    stores: stores
  });
};

exports.editStore = async (req, res) => {
  const store = await Store.findOne({ _id: req.params.id });
  console.log(store);
  res.render("editStore", { title: `Edit ${store.name}`, store });
};

exports.updateStore = async (req, res) => {
  const store = await Store.findOneAndUpdate({ _id: req.params.id }, req.body, {
    new: true, // returns new store
    runValidators: true // force the data to run through validators
  }).exec();

  req.flash(
    "success",
    `Successfully updated store <strong>${store.name}</strong>.
    <a href="/stores/${store.slug}">View store</a>`
  );

  res.redirect(`/stores/${store._id}/edit`);
};
