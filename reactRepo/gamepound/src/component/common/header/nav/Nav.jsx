import React from 'react';
import { Link, NavLink } from 'react-router-dom';
import styled from 'styled-components';

const StyledNavDiv = styled.nav`
    display: flex;
    align-items: center;
    gap: 20px;

    & > a { // 1depth
        padding: 20px 10px;
        box-sizing: border-box;
        font-weight: 500;
        transition: .2s;
        border-bottom: 2px solid transparent;
        &:hover,
        &.active {
            border-bottom: 2px solid #333;
        }
    }
    & .categoryArea {
        & > a { // 1depth
            padding: 20px 10px;
            font-weight: 500;
            transition: .2s;
        }

        & > ul { // 2depth
            display: none;
            position: absolute;
            justify-content: center;
            top: 126px;
            left: 0;
            background-color: #fff;
            width: 100%;
            box-shadow: 0 8px 8px -3px rgba(0, 0, 0, .07);
            padding: 20px 0 30px;
            box-sizing: border-box;

            & .inner {
                display: flex;
                flex-direction: column;
                padding: 0 10px;
                position: relative;
                box-sizing: border-box;
                & > li { 
                    display: flex;
                    max-width: 100px;
                    gap: 40px;
                    &::after {
                        content: "";
                        display: block;
                        position: absolute;
                        left: 120px;
                        top: -5px;
                        width: 1px;
                        height: calc(100% + 10px);
                        background-color: #ddd;
                    }
                    & > a {
                        display: flex;
                        padding: 7px 20px;
                        border-radius: 5px;
                        font-weight: 500;
                        transition: .2s;
                        
                    }
                    &:hover > a {
                        background-color: #f5f5f5;
                    }
                    & ul { // 3depth
                        display: none;
                        align-items: flex-start;
                        gap: 10px;
                        position: absolute;
                        top: 0;
                        left: 100px;
                        width: calc(100% - 100px);
                        height: 100%;
                        padding-left: 50px;
                        box-sizing: border-box;
                        & a {
                            display: flex;
                            padding: 5px 15px;
                            border-radius: 5px;
                            font-size: 14px;
                        }
                        & li:hover a {
                            background-color: #f5f5f5;
                        }
                    }
                    &:hover ul {
                        display: flex;
                    }
                    & + li {
                        margin-top: 10px;
                    }
                }
            }
        }
        &:hover > ul {
            display: flex;
        }
    }
    
`;

const Nav = () => {
    return (
        <StyledNavDiv>

            <div className="categoryArea">
                <NavLink to='/ff0'>카테고리</NavLink>
                <ul>
                    <div className="inner">
                        <li>
                            <Link to=''>전체</Link>
                        </li>
                        <li>
                            <Link to=''>비디오</Link>
                            <ul>
                                <li><Link to=''>비디오</Link></li>
                                <li><Link to=''>비디오</Link></li>
                                <li><Link to=''>비디오</Link></li>
                                <li><Link to=''>비디오</Link></li>
                                <li><Link to=''>비디오</Link></li>
                                <li><Link to=''>비디오</Link></li>
                            </ul>
                        </li>
                        <li>
                            <Link to=''>모바일</Link>
                            <ul>
                                <li><Link to=''>비디오</Link></li>
                                <li><Link to=''>비디오</Link></li>
                                <li><Link to=''>비디오</Link></li>
                                <li><Link to=''>비디오</Link></li>
                                <li><Link to=''>비디오</Link></li>
                                <li><Link to=''>비디오</Link></li>
                            </ul>
                        </li>
                    </div>
                </ul>
            </div>

            <NavLink to='/ff1'>홈</NavLink>
            <NavLink to='/ff2'>인기</NavLink>
            <NavLink to='/ff3'>신규</NavLink>
            <NavLink to='/ff4'>마감임박</NavLink>
            <NavLink to='/ff5'>공개예정</NavLink>
            
        </StyledNavDiv>
    );
};

export default Nav;