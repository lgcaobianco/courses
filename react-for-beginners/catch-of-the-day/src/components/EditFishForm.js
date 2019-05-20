import React from "react";
import PropTypes from "prop-types";
import { formatPrice } from "../helpers";
class EditFishForm extends React.Component {
  static propTypes = {
    detail: PropTypes.shape({
      image: PropTypes.string,
      name: PropTypes.string,
      desc: PropTypes.string,
      status: PropTypes.string,
      price: PropTypes.number
    }),
    index: PropTypes.string,
    updateFish: PropTypes.func,
    deleteFish: PropTypes.func
  };
  handleChange = event => {
    console.log(event.currentTarget.value);
    const updatedFish = {
      ...this.props.fish,
      [event.currentTarget.name]: event.currentTarget.value
    };
    this.props.updateFish(this.props.index, updatedFish);
  };

  render() {
    return (
      <div className="fish-edit">
        <input
          type="text"
          name="name"
          value={this.props.detail.name}
          onChange={this.handleChange}
        />
        <input
          type="text"
          name="price"
          value={formatPrice(this.props.detail.price)}
          onChange={this.handleChange}
        />
        <select
          type="text"
          name="status"
          value={this.props.detail.status}
          onChange={this.handleChange}
        >
          <option value="available">Fresh</option>
          <option value="unavailable">Sold out</option>
        </select>
        <textarea
          name="desc"
          value={this.props.detail.desc}
          onChange={this.handleChange}
        />
        <img
          src={this.props.detail.image}
          alt={this.props.detail.name}
          onChange={this.handleChange}
        />
        <button onClick={() => this.props.deleteFish(this.props.index)}>
          Remove Fish
        </button>
      </div>
    );
  }
}
export default EditFishForm;
