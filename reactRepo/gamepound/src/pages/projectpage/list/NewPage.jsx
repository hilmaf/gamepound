import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import ProjectListBoxInfo from '../../../component/project/ProjectListBoxInfo';

const StyledAllDiv = styled.div`
    width: 100%;
    .inner {
        width: 1200px;
        margin: 0 auto;
        & > div:first-child{
            & > div:first-child{
                border: 1px solid #c9c9c9;
                border-radius: 5px;
                width: fit-content;
                height: fit-content;
                padding: 5px;
            }
            & > div:last-child{
                & > span{
                    color: var(--red-color);
                }
                margin-top: 20px;
                margin-bottom: 25px;
            }
            
        }
        & > div:last-child{
            display: flex;
            flex-wrap: wrap;
        }
    }
`;

const NewPage = () => {

    const [newVoList, setNewVoList] = useState([]);

    useEffect(()=>{
        fetch("http://127.0.0.1:8889/gamepound/project/list/new")
        .then((resp)=>{return resp.json()})
        .then((data)=>{
            console.log("newPage > fetch");
            setNewVoList(data);
        })
        .catch((e)=>{console.log("오류 : " + e);})
        ;
    }, []);

    return (
        <StyledAllDiv>
            <div className='inner'>
                <div>
                    <div>달성률 ▽</div>
                    <div><span>20</span>개의 프로젝트가 있습니다.</div>
                </div>
                <div>
                    {
                        newVoList.map((vo)=>{
                            return(<ProjectListBoxInfo project={vo}/>);
                        })
                    }
                </div>
            </div>
        </StyledAllDiv>
    );
};

export default NewPage;