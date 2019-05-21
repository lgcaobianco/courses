import Link from "next/link";
const Nav = props => {
  return (
    <div>
      <Link href="/sell">
        <a>sell</a>
      </Link>
      <Link href="/index">
        <a>home</a>
      </Link>
    </div>
  );
};
export default Nav;
