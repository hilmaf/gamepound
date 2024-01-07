import React from 'react';
import styled from 'styled-components';

const StyledProfileAreaDiv = styled.div`
    width: 1200px;
    height: 80px;
    display: flex;
    align-items: center;
    padding-top: 40px;
    padding-left: 30px;
    padding-bottom: 20px;

    & > img {
        width: 80px;
        height: 80px;
        border-radius: 80px;
        object-fit: cover;
    } 

    & > .nick_area {
        padding-left: 20px;

        & > #nick {
            font-size: 20px;
        }

        & > button {
            background-color: rgba(255, 145, 77, 0.4);
            padding: 5px 8px;
            margin-top: 8px;
            cursor: pointer;
        }
    }
`;

const ProfileArea = () => {
    return (
        <StyledProfileAreaDiv>
            <img src='https://cdn.akamai.steamstatic.com/steam/apps/416600/capsule_616x353.jpg?t=1689347261'/>
            <div className='nick_area'>
                <div id='nick'>닉네임</div>
                <button>계정 관리</button>
            </div>
        </StyledProfileAreaDiv>
    );
};

export default ProfileArea;